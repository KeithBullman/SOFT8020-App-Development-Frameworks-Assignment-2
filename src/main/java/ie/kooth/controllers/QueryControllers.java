//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.controllers;

import ie.kooth.entities.Note;
import ie.kooth.entities.Student;
import ie.kooth.service.NoteService;
import ie.kooth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueryControllers {
    @Autowired
    StudentService studentService;

    @Autowired
    NoteService noteService;

    //localhost:8080/student/1

    @GetMapping("/student/{studentId}")
    public String showStudentByStudentId(@PathVariable("studentId") int studentId, Model model){

        Student student = studentService.getStudentByStudentId(studentId);

        if(student == null){
            model.addAttribute("studentid", studentId);
            return "notfounderror";
        }
        model.addAttribute("student", student);
        model.addAttribute("notes", noteService.getAllNotesForStudent(studentId));
        return "student";
    }

    @GetMapping("/students")
    public String showStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/inactivestudents")
    public String showInactiveStudents(Model model){
        model.addAttribute("inactivestudents", studentService.getStudentsWithoutNotes());
        return "inactivestudents";
    }

    @GetMapping("/note")
    public String showNoteById(@RequestParam(name="noteid", required = true) int noteId, Model model) {
        Note note = noteService.getNoteByNoteId(noteId);
        if (note == null) {
            model.addAttribute("noteId", noteId);
            return "notfounderror";
        }
        model.addAttribute("note", note);
        return "note";
    }

    @GetMapping("/delete/student/{studentId}")
    public String deleteMappingStudent(@PathVariable(name="studentId") int studentId, Model model){
        if(studentService.delete(studentId)){
            return "redirect:/students";
        }
        model.addAttribute("studentId", studentId);
        return "notfounderror";
    }

}
