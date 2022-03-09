//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.service;

import ie.kooth.entities.Note;
import ie.kooth.entities.Student;
import java.util.List;

public interface NoteService {

    Note save(String text, Student student);

    List<Note> getAllNotesForStudent(int studentId);

    Note getNoteByNoteId(int noteId);

}
