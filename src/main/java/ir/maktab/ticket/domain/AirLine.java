package ir.maktab.ticket.domain;


import ir.maktab.ticket.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AirLine extends BaseEntity<Long> {

    private String name;
    @OneToMany(mappedBy = "airLine")
    private List<Flight> flights;
    @OneToOne
    private Admin admin;

}
