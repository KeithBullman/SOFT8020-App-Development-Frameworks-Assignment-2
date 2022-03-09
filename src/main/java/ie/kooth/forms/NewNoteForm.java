//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.forms;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class NewNoteForm {
    @Size(min=5, max=100)
    private String newNoteText;

    @NotNull
    private int noteStudentId;
}
