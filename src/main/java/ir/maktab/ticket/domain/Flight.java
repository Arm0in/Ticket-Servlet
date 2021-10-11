package ir.maktab.ticket.domain;

import ir.maktab.ticket.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flight extends BaseEntity<Long> {
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double economyCost;
    private Double businessCost;
    private Integer economySeats;
    private Integer businessSeats;
    @ManyToOne
    @JoinColumn(name = "airLine_id")
    private AirLine airLine;
    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets;

    @Override
    public String toString() {
        return "[" + getId() + "]" +
                "from=" + origin +
                ", to=" + destination +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", economyCost=" + economyCost +
                ", businessCost=" + businessCost +
                ", economySeats=" + economySeats +
                ", businessSeats=" + businessSeats +
                ", airLine=" + airLine.getName();
    }
}
