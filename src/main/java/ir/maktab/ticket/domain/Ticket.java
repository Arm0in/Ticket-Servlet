package ir.maktab.ticket.domain;


import ir.maktab.ticket.base.domain.BaseEntity;
import ir.maktab.ticket.domain.enumeration.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntity<Long> {
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
//    private Long seatNumber;
    private Double cost;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @ManyToOne
    private Passenger passenger;

}
