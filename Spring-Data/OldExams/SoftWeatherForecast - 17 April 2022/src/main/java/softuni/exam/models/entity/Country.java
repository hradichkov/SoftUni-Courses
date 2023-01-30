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
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(name = "country_name", unique = true, nullable = false)
    private String countryName;

    @Column(nullable = false)
    private String currency;
}
