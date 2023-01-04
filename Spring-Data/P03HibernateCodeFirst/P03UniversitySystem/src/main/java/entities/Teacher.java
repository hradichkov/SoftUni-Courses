package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Teacher extends Person {

    @Column
    private String email;

    @Column(name = "salary_per_hour")
    private double salaryPerHour;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;
}
