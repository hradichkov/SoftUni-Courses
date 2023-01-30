package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cities")
public class City extends BaseEntity{

    @Column(name = "city_name", unique = true, nullable = false)
    private String cityName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int population;
    @ManyToOne(optional = false)
    private Country country;
}
