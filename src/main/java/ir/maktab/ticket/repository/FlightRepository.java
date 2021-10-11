package ir.maktab.ticket.repository;

import ir.maktab.ticket.base.repository.BaseRepository;
import ir.maktab.ticket.domain.Flight;

import java.util.List;

public interface FlightRepository extends BaseRepository<Flight, Long> {
    List<Flight> getFlightsByFromTo(String from, String to);
}
