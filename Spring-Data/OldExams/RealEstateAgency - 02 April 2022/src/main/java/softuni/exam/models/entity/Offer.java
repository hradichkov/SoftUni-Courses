package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "published_on", nullable = false)
    private LocalDate publishedOn;

    @ManyToOne(optional = false)
    private Apartment apartment;

    @ManyToOne(optional = false)
    private Agent agent;

    @Override
    public String toString() {
//        "Agent {firstName} {lastName} with offer №{offerId}:
//        -Apartment area: {area}
//        --Town: {townName}
//        ---Price: {price}$
        return "Agent " + this.agent.getFirstName() + " " + this.agent.getLastName() +
                "with offer №" + this.getId() + System.lineSeparator() +
                "-Apartment area: " + this.apartment.getArea() + System.lineSeparator() +
                "--Town: " + this.apartment.getTown().getTownName() + System.lineSeparator() +
                " ---Price: " + this.price + "$";
    }
}
