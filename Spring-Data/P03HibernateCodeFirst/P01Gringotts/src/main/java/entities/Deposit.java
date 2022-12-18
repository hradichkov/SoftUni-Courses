package P03HibernateCodeFirst.P01Gringotts.src.main.java.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Entity
@Table
public class Deposit {

    @Id
    @Column
    private long id;

    @Column(length = 20)
    private String group;

    @Column
    private LocalDate startDate;

    @Column
    private Double amount;

    @Column
    private Double interest;

    @Column
    private Double charge;

    @Column
    private LocalDate expirationDate;

    @Column
    private boolean isExpired;

}
