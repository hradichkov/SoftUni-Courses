package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Visitation extends BaseEntity {

    @Column
    private Date date;

    @Column
    private String comments;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Patient patient;

}