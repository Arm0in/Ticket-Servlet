package ir.maktab.ticket.domain;


import ir.maktab.ticket.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AirLine extends BaseEntity<Long> {

    private String name;
    @OneToMany(mappedBy = "airLine", cascade = CascadeType.ALL)
    private List<Flight> flights;
}
