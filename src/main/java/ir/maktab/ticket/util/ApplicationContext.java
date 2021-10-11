package ir.maktab.ticket.util;

import ir.maktab.ticket.repository.AirLineRepository;
import ir.maktab.ticket.repository.FlightRepository;
import ir.maktab.ticket.repository.PassengerRepository;
import ir.maktab.ticket.repository.TicketRepository;
import ir.maktab.ticket.repository.impl.AirLineRepositoryImpl;
import ir.maktab.ticket.repository.impl.FlightRepositoryImpl;
import ir.maktab.ticket.repository.impl.PassengerRepositoryImpl;
import ir.maktab.ticket.repository.impl.TicketRepositoryImpl;
import ir.maktab.ticket.service.AirLineService;
import ir.maktab.ticket.service.FlightService;
import ir.maktab.ticket.service.PassengerService;
import ir.maktab.ticket.service.TicketService;
import ir.maktab.ticket.service.impl.AirLineServiceImpl;
import ir.maktab.ticket.service.impl.FlightServiceImpl;
import ir.maktab.ticket.service.impl.PassnegerServiceImpl;
import ir.maktab.ticket.service.impl.TicketServiceImpl;

import javax.persistence.EntityManager;

public class ApplicationContext {
    private static final AirLineRepository AIR_LINE_REPOSITORY;
    private static final AirLineService AIR_LINE_SERVICE;

    private static final FlightRepository FLIGHT_REPOSITORY;
    private static final FlightService FLIGHT_SERVICE;

    private static final PassengerRepository PASSENGER_REPOSITORY;
    private static final PassengerService PASSENGER_SERVICE;

    private static final TicketRepository TICKET_REPOSITORY;
    private static final TicketService TICKET_SERVICE;

    static {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        AIR_LINE_REPOSITORY = new AirLineRepositoryImpl(entityManager);
        AIR_LINE_SERVICE = new AirLineServiceImpl(AIR_LINE_REPOSITORY);

        FLIGHT_REPOSITORY = new FlightRepositoryImpl(entityManager);
        FLIGHT_SERVICE = new FlightServiceImpl(FLIGHT_REPOSITORY);

        PASSENGER_REPOSITORY = new PassengerRepositoryImpl(entityManager);
        PASSENGER_SERVICE = new PassnegerServiceImpl(PASSENGER_REPOSITORY);

        TICKET_REPOSITORY = new TicketRepositoryImpl(entityManager);
        TICKET_SERVICE = new TicketServiceImpl(TICKET_REPOSITORY);
    }

    public static AirLineService getAirLineService() {
        return AIR_LINE_SERVICE;
    }

    public static FlightService getFlightService() {
        return FLIGHT_SERVICE;
    }

    public static PassengerService getPassengerService() {
        return PASSENGER_SERVICE;
    }

    public static TicketService getTicketService() {
        return TICKET_SERVICE;
    }
}
