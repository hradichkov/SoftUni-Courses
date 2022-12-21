package P03HibernateCodeFirst.P01Gringotts.src.main.java.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class MagicWand {
    @Id
    @Column
    private Long id;

    @Column(length = 100)
    private String creator;

    @Column
    private Long size;
}
