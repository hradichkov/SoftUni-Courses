package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class BankAccount extends BillingDetail{
    @Column(name = "bank_name")
    private String name;

    @Column(name = "swift_code")
    private String swiftCode;
}
