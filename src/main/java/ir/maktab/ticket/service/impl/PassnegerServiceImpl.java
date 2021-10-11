package ir.maktab.ticket.service.impl;

import ir.maktab.ticket.base.service.impl.BaseServiceImpl;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.repository.PassengerRepository;
import ir.maktab.ticket.service.PassengerService;

public class PassnegerServiceImpl extends BaseServiceImpl<Passenger, Long, PassengerRepository> implements PassengerService {
    public PassnegerServiceImpl(PassengerRepository repository) {
        super(repository);
    }


}
