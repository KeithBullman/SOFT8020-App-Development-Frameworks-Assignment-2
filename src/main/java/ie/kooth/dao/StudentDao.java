//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.dao;

import ie.kooth.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

public interface StudentDao extends JpaRepository<Student, Integer> {
    Student findByStudentFirst(String firstName);

    boolean existsByStudentFirst(String firstName);

    List<Student> findAllByOrderByStudentFirstAsc();

    Student getStudentByStudentId(int id);

    Student getStudentByStudentEmail(String email);

    @Query(value = "SELECT * FROM STUDENT WHERE STUDENTID NOT IN (SELECT STUDENTID FROM NOTE)", nativeQuery = true)
    List<Student> getStudentsWithoutNotes();

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.studentFirst = :newName WHERE s.studentId = :studentId")
    void changeStudentName(@Param("newName") String newName, @Param("studentId") int studentId);

}
