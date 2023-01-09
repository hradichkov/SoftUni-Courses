package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "credit_card")
public class CreditCard extends BillingDetail{

    @Column
    private String cardType;

    @Column(name = "expiration_month")
    private Date expirationMonth;

    @Column(name = "expiration_year")
    private Date expirationYear;
}
