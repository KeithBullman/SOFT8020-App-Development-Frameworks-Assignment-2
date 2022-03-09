//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.controllers;

import ie.kooth.forms.NewStudentForm;
import ie.kooth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class NewStudentControllers {

    @Autowired
    StudentService studentService;

    @GetMapping("/newstudent")
    public String getNewStudent(Model model){
        model.addAttribute("newStudentForm", new NewStudentForm());
        return "newstudent";
    }

    @PostMapping("/newstudent")
    public String postNewStudent(@Valid NewStudentForm newStudentForm, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "newstudent";
        }

        studentService.save(newStudentForm.getNewStudentEmail(), newStudentForm.getNewStudentFirst(), newStudentForm.getNewStudentLast());

        if(studentService.getStudentByEmail(newStudentForm.getNewStudentEmail()) == null){
            redirectAttributes.addFlashAttribute("duplicateStudentName", true);
            return "redirect:newstudent";
        }

        return "redirect:student/" + studentService.getStudentByEmail(newStudentForm.getNewStudentEmail()).getStudentId();
    }

}
