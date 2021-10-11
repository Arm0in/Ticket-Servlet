package ir.maktab.ticket.service;

import ir.maktab.ticket.base.service.BaseService;
import ir.maktab.ticket.domain.Flight;

import java.util.List;

public interface FlightService extends BaseService<Flight, Long> {
    List<Flight> getFlightsByFromTo(String from, String to);
}
