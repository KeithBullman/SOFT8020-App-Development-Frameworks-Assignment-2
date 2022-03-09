//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.service;

import ie.kooth.entities.Student;
import java.util.List;

public interface StudentService {

    Student getStudentByStudentId(int id);
    Student save(String email, String first, String last);
    List<Student> getAllStudents();
    boolean changeStudentName(String newName, int studentId);
    boolean delete(int id);
    Student getStudentByEmail(String email);
    List<Student> getStudentsAlphabetically();
    List<Student> getStudentsWithoutNotes();

}
