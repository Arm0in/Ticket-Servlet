package ir.maktab.ticket.service.impl;

import ir.maktab.ticket.base.service.impl.BaseServiceImpl;
import ir.maktab.ticket.domain.Ticket;
import ir.maktab.ticket.repository.TicketRepository;
import ir.maktab.ticket.service.TicketService;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository> implements TicketService {
    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }
}
