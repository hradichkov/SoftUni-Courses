package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne(optional = false)
    private Mechanic mechanic;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parts_id")
    private Part part;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cars_id")
    private Car car;

    @Override
    public String toString() {
//        •	"Car {carMake} {carModel} with {kilometers}km
//         -Mechanic: {firstName} {lastName} - task №{taskId}:¬¬
//        --Engine: {engine}
//        ---Price: {taskPrice}$

        return "Car " + this.car.getCarMake() + " " + this.car.getCarModel() +
                " with " + this.car.getKilometers() + "km" + System.lineSeparator() +
                "-Mechanic: " + this.mechanic.getFirstName() + " " + this.mechanic.getLastName() +
                " - task №" + getId() + ":" + System.lineSeparator() +
                " --Engine: " + this.car.getEngine() + System.lineSeparator() +
                "---Price: " + this.price + "$";
    }
}
