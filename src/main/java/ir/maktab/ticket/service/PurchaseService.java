package ir.maktab.ticket.service;

import ir.maktab.ticket.domain.Flight;
import ir.maktab.ticket.domain.Passenger;
import ir.maktab.ticket.domain.enumeration.SeatType;

public interface PurchaseService {
    void purchase(Passenger passenger, Flight flight, SeatType seatType);
}
