//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Note {
    @Id
    @GeneratedValue
    @Column(name="noteid")
    private int noteId;
    @Column(name="dateofcreation", nullable = false)
    private String dateOfCreation;
    @Column(name="text", nullable = false)
    private String text;
    @ManyToOne
    @JoinColumn(name = "studentid")
    private Student studentId;

    public Note(String date, String note, Student studentid) {
        this.dateOfCreation = date;
        this.text = note;
        this.studentId = studentid;
    }
}
