package ir.maktab.ticket.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends User{
    private String firstname;
    private String lastname;
    @OneToOne(mappedBy = "admin")
    private AirLine airLine;
}
