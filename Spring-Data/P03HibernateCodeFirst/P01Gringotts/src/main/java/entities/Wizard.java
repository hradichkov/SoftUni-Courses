package P03HibernateCodeFirst.P01Gringotts.src.main.java.entities;

import entities.Deposit;
import entities.MagicWand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Wizard {
    @Id
    @Column
    private long id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 60, nullable = false)
    private String lastName;

    @Column(length = 1000)
    private String notes;

    @Column(nullable = false)
    private long age;

    @OneToOne
    @JoinColumn
    private MagicWand magicWand;

    @OneToMany
    private List<Deposit> deposits;
}
