//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.forms;

import lombok.Data;
import javax.validation.constraints.Size;

@Data
public class NewStudentForm {
    @Size(min=5, max=30)
    private String newStudentEmail;

    @Size(min=3, max=15)
    private String newStudentFirst;

    @Size(min=3, max=15)
    private String newStudentLast;
}
