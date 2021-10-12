package ir.maktab.ticket.repository.impl;

import ir.maktab.ticket.base.repository.BaseRepositoryImpl;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.domain.Ticket;
import ir.maktab.ticket.repository.TicketRepository;

import javax.persistence.EntityManager;

public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket, Long> implements TicketRepository {

    public TicketRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    @Override
    public Long countPassengerTickets(Passenger passenger) {
        return entityManager.createQuery(
                "SELECT COUNT(passenger) FROM Ticket WHERE passenger=:passengerId"
                , Long.class).setParameter("passengerId", passenger.getId()).getSingleResult();
    }
}
