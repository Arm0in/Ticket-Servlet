package ir.maktab.ticket.service.impl;

import ir.maktab.ticket.base.service.impl.BaseServiceImpl;
import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.repository.FlightRepository;
import ir.maktab.ticket.service.FlightService;

import java.util.List;

public class FlightServiceImpl extends BaseServiceImpl<Flight, Long, FlightRepository> implements FlightService {
    public FlightServiceImpl(FlightRepository repository) {
        super(repository);
    }

    @Override
    public List<Flight> getFlightsByFromTo(String from, String to) {
        return repository.getFlightsByFromTo(from, to);
    }
}
