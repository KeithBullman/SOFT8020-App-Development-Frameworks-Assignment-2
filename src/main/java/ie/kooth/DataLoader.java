//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth;

import ie.kooth.entities.Student;
import ie.kooth.service.NoteService;
import ie.kooth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    StudentService studentService;

    @Autowired
    NoteService noteService;

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student();
        student1 = studentService.save("sambigs@mycit.ie", "Sam", "Bigs");

        Student student2 = new Student();
        student2 = studentService.save("koothmagooth@mycit.ie", "Kooth", "Magooth");

        Student student3 = new Student();
        student3 = studentService.save("philipriordan@mycit.ie", "Philip", "Riordan");

        Student student4 = new Student();
        student4 = studentService.save("donmulcahy@mycit.ie", "Don", "Mulcahy");

        Student student5 = new Student();
        student5 = studentService.save("jessicawaters@mycit.ie", "Jessica", "Waters");

        noteService.save("Study more!", student1);

        noteService.save("More work required.", student2);

        noteService.save("Well done!", student2);

        noteService.save("Missing homework.", student5);

    }
}
