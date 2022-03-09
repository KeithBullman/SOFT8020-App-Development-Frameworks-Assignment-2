//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.service;

import ie.kooth.dao.NoteDao;
import ie.kooth.dao.StudentDao;
import ie.kooth.entities.Note;
import ie.kooth.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    NoteDao noteDao;

    @Autowired
    StudentDao studentDao;

    @Override
    public Note save(String text, Student student) {
        if(!studentDao.existsById(student.getStudentId())){
            System.out.println("Student doesn't exist; note did not save.");
            return null;
        }
        else{
            System.out.println("Note saved!");
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yy");
            String formattedDate = myDateObj.format(myFormatObj);

            Note note = new Note(formattedDate, text, student);
            return noteDao.save(note);
        }
    }

    @Override
    public List<Note> getAllNotesForStudent(int studentId) {
        return noteDao.findAllByStudentId_StudentId(studentId);
    }

    @Override
    public Note getNoteByNoteId(int noteId) {
        return noteDao.getNoteByNoteId(noteId);
    }

}
