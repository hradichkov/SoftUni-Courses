package P03HibernateCodeFirst.P02Sales.src.main.java.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Customer extends BaseEntity{

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String creditCardNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Sale> sales;
}
