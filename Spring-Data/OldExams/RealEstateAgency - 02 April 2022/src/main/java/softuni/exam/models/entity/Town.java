package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(name = "town_name", nullable = false, unique = true)
    private String townName;

    @Column(nullable = false)
    private int population;
}
