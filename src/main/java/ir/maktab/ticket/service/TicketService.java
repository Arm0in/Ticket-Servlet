package ir.maktab.ticket.service;


import ir.maktab.ticket.base.service.BaseService;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.domain.Ticket;

public interface TicketService extends BaseService<Ticket, Long> {
    Long countPassengerTickets(Passenger passenger);
}
