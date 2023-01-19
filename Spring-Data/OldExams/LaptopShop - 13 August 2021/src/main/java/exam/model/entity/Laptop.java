package exam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {

    @Column(name = "mac_address", unique = true, nullable = false)
    private String macAddress;

    @Column(name = "cpu_speed", nullable = false)
    private double cpuSpeed;

    @Column(nullable = false)
    private int ram;

    @Column(nullable = false)
    private int storage;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;
    @Enumerated
    @Column(name = "warranty_type", nullable = false)
    private WarrantyType warrantyType;

    @ManyToOne(optional = false)
    private Shop shop;

    @Override
    public String toString() {
        //Laptop - {mac address}
//        *Cpu speed - {cpu speed}
//        **Ram - {ram}
//        ***Storage - {storage}
//        ****Price - {price}
//        #Shop name - {name of the shop}
//        ##Town - {the name of the town of shop}
        return "Laptop - " + this.macAddress + System.lineSeparator() +
                "*Cpu speed - " + this.cpuSpeed + System.lineSeparator() +
                "**Ram - " + this.ram + System.lineSeparator() +
                "***Storage - " + this.storage + System.lineSeparator() +
                "****Price - " + this.price + System.lineSeparator() +
                "#Shop name - " + this.shop.getName() + System.lineSeparator() +
                "##Town - " + this.shop.getTown().getName() + System.lineSeparator();
    }
}
