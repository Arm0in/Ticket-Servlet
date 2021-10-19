package ir.maktab.ticket.service.impl;

import ir.maktab.ticket.base.service.impl.BaseServiceImpl;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.repository.PassengerRepository;
import ir.maktab.ticket.service.PassengerService;

public class PassengerServiceImpl extends BaseServiceImpl<Passenger, Long, PassengerRepository> implements PassengerService {
    public PassengerServiceImpl(PassengerRepository repository) {
        super(repository);
    }

    @Override
    public void addToBalance(Passenger passenger, Double amount) {
        repository.getEntityManager().getTransaction().begin();
        passenger.setBalance(passenger.getBalance() + (Double) amount);
        repository.save(passenger);
        repository.getEntityManager().getTransaction().commit();
    }
}
