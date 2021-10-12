package ir.maktab.ticket.domain;

import ir.maktab.ticket.base.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sale extends BaseEntity<Long> {
    private Double discount;
    @OneToOne
    private Flight flight;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
