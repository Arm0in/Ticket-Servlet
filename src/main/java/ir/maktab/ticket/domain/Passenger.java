package ir.maktab.ticket.domain;


import ir.maktab.ticket.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends User {
    private String firstname;
    private String lastname;
    private String mobileNumber;
    private LocalDate birthDate;
    private Double balance;

    @Override
    public String toString() {
        return "Passenger{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", birthDate=" + birthDate +
                ", balance=" + balance +
                '}';
    }
}
