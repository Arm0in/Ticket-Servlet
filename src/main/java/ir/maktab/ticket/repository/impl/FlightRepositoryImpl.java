package ir.maktab.ticket.repository.impl;

import ir.maktab.ticket.base.repository.BaseRepositoryImpl;
import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.repository.FlightRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class FlightRepositoryImpl extends BaseRepositoryImpl<Flight, Long> implements FlightRepository {

    public FlightRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Flight> getEntityClass() {
        return Flight.class;
    }

    @Override
    public List<Flight> getFlightsByFromTo(String from, String to) {
        return entityManager.createQuery(
                "FROM Flight f WHERE f.origin = :from AND f.destination = :to", Flight.class
        ).setParameter("from", from).setParameter("to", to).getResultList();
    }
}
