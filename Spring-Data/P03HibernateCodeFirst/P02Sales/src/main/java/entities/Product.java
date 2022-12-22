package P03HibernateCodeFirst.P02Sales.src.main.java.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Documented;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Product extends BaseEntity{

    @Column
    private String name;

    @Column
    private Double quantity;

    @Column
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private Set<Sale> sales;
}
