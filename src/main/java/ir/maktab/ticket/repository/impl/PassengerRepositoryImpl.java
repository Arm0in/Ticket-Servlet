package ir.maktab.ticket.repository.impl;

import ir.maktab.ticket.base.repository.BaseRepositoryImpl;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.repository.PassengerRepository;

import javax.persistence.EntityManager;

public class PassengerRepositoryImpl extends BaseRepositoryImpl<Passenger, Long> implements PassengerRepository {

    public PassengerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Passenger> getEntityClass() {
        return Passenger.class;
    }


}
