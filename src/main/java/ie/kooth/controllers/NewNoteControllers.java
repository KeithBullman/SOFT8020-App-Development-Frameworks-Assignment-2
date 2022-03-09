//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.controllers;

import ie.kooth.entities.Note;
import ie.kooth.entities.Student;
import ie.kooth.forms.NewNoteForm;
import ie.kooth.service.NoteService;
import ie.kooth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class NewNoteControllers {

    @Autowired
    NoteService noteService;

    @Autowired
    StudentService studentService;

    @GetMapping("/newnote")
    public String getNewStudent(Model model){
        model.addAttribute("newNoteForm", new NewNoteForm());
        model.addAttribute("students", studentService.getStudentsAlphabetically());
        return "newnote";
    }

    @PostMapping("/newnote")
    public String postNewStudent(Model model, @Valid NewNoteForm newNoteForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("students", studentService.getStudentsAlphabetically());
            return "newnote";
        }

        Student student = studentService.getStudentByStudentId(newNoteForm.getNoteStudentId());
        Note note = noteService.save(newNoteForm.getNewNoteText(), student);
        return "redirect:note?noteid=" + note.getNoteId();
    }

}
