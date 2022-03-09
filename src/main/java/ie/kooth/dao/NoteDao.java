//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.dao;

import ie.kooth.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteDao extends JpaRepository<Note, Integer> {

    List<Note> findAllByStudentId_StudentId(int studentId);

    Note getNoteByNoteId(int noteId);

}
