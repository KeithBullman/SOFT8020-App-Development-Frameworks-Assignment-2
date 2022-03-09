//Name: Keith Bullman
//ID: R00178736
//Class: SDH4-A

package ie.kooth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="studentid")
    private int studentId;
    @Column(name="studentemail", nullable = false)
    private String studentEmail;
    @Column(name="studentfirst", nullable = false)
    private String studentFirst;
    @Column(name="studentlast", nullable = false)
    private String studentLast;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentFirst='" + studentFirst + '\'' +
                ", studentLast='" + studentLast + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "studentId", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    List<Note> notesRegardingStudent = new ArrayList<>();

    public Student(String email, String first, String last) {
        this.studentEmail = email;
        this.studentFirst = first;
        this.studentLast = last;
    }
}
