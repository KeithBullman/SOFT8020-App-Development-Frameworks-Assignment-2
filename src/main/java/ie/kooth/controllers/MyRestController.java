//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.controllers;

import ie.kooth.entities.Note;
import ie.kooth.entities.Student;
import ie.kooth.forms.NewNoteForm;
import ie.kooth.forms.NewStudentForm;
import ie.kooth.service.NoteService;
import ie.kooth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// You can use the given API endpoints or you can write your own.

@RestController    // returns the data as Json objects
@RequestMapping("myapi")   // all requests will include myapi
public class MyRestController {

    @Autowired
    StudentService studentService;

    @Autowired
    NoteService noteService;

    // Returns a json list of students
    @GetMapping("/students")
    List<Student> getEveryStudent() {
        return studentService.getAllStudents();
    }

    // return a student or 404
    @GetMapping("/student/{studentId}")
    ResponseEntity<Student> getStudent(@PathVariable(name="studentId") int studentId) {
        Student student = studentService.getStudentByStudentId(studentId);
        if (student == null)
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<Student>(student, HttpStatus.FOUND);
    }

    // Returns a list of notes relating to a student (as Json with associated headers etc)
    @GetMapping("/notes/{noteId}")
    ResponseEntity<List<Note>> getStudentsNotes(@PathVariable(name="studentId") int studentId) {
        Student student = studentService.getStudentByStudentId(studentId);
        if (student == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(noteService.getAllNotesForStudent(studentId), HttpStatus.FOUND);
    }

    // a delete request
    @DeleteMapping("/student/{studentId}")
    ResponseEntity<Student> deleteStudent(@PathVariable(name="studentId") int studentId) {
        boolean status = studentService.delete(studentId);
        if (status)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create a new student given its name
    // This might also be @PutMapping but this is what I chose to use
    @PostMapping("/student")
    public ResponseEntity<Student> addNewStudent(@RequestBody NewStudentForm newStudentForm)
    {
        Student student = studentService.save(newStudentForm.getNewStudentEmail(), newStudentForm.getNewStudentFirst(), newStudentForm.getNewStudentLast());
        if ( student == null )
            return new ResponseEntity<>( HttpStatus.CONFLICT);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Create a new note given its name
    // This might also be @PutMapping but this is what I chose to use
    @PostMapping("/note")
    public ResponseEntity<Note> addNewNote(@RequestBody NewNoteForm newNoteForm)
    {
        Student student = studentService.getStudentByStudentId(newNoteForm.getNoteStudentId());
        if (student == null)
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        Note note = noteService.save(newNoteForm.getNewNoteText(), student);

        if ( note == null )
            return new ResponseEntity<>( HttpStatus.CONFLICT);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }
}