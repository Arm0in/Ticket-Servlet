package ir.maktab.ticket.repository;

import ir.maktab.ticket.base.repository.BaseRepository;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.domain.Ticket;

public interface TicketRepository extends BaseRepository<Ticket, Long> {
    Long countPassengerTickets(Passenger passenger);
}
