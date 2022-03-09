//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.service;

import ie.kooth.dao.StudentDao;
import ie.kooth.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentDao studentDao;

    @Override
    public Student getStudentByStudentId(int id) {
        return studentDao.getStudentByStudentId(id);
    }

    @Override
    public Student save(String email, String first, String last) {
        Student saveStudent = new Student(email, first, last);
        System.out.println("Student Saved!");
        return studentDao.save(saveStudent);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public boolean changeStudentName(String newName, int studentId) {
        Optional<Student> optional = studentDao.findById(studentId);
        if(optional.isPresent() && studentDao.findByStudentFirst(newName) == null){
            studentDao.changeStudentName(newName, studentId);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if(studentDao.existsById(id)){
            studentDao.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentDao.getStudentByStudentEmail(email);
    }

    @Override
    public List<Student> getStudentsAlphabetically() {
        return studentDao.findAllByOrderByStudentFirstAsc();
    }

    @Override
    public List<Student> getStudentsWithoutNotes() {
        return studentDao.getStudentsWithoutNotes();
    }

}