package ir.maktab.ticket.util;

import ir.maktab.ticket.repository.*;
import ir.maktab.ticket.repository.impl.*;
import ir.maktab.ticket.service.*;
import ir.maktab.ticket.service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {
    private static final AdminRepository ADMIN_REPOSITORY;
    private static final AdminService ADMIN_SERVICE;

    private static final AirLineRepository AIR_LINE_REPOSITORY;
    private static final AirLineService AIR_LINE_SERVICE;

    private static final FlightRepository FLIGHT_REPOSITORY;
    private static final FlightService FLIGHT_SERVICE;

    private static final PassengerRepository PASSENGER_REPOSITORY;
    private static final PassengerService PASSENGER_SERVICE;

    private static final TicketRepository TICKET_REPOSITORY;
    private static final TicketService TICKET_SERVICE;

    private static final UserRepository USER_REPOSITORY;
    private static final UserService USER_SERVICE;

    static {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        ADMIN_REPOSITORY = new AdminRepositoryImpl(entityManager);
        ADMIN_SERVICE = new AdminServiceImpl(ADMIN_REPOSITORY);

        AIR_LINE_REPOSITORY = new AirLineRepositoryImpl(entityManager);
        AIR_LINE_SERVICE = new AirLineServiceImpl(AIR_LINE_REPOSITORY);

        FLIGHT_REPOSITORY = new FlightRepositoryImpl(entityManager);
        FLIGHT_SERVICE = new FlightServiceImpl(FLIGHT_REPOSITORY);

        PASSENGER_REPOSITORY = new PassengerRepositoryImpl(entityManager);
        PASSENGER_SERVICE = new PassnegerServiceImpl(PASSENGER_REPOSITORY);

        TICKET_REPOSITORY = new TicketRepositoryImpl(entityManager);
        TICKET_SERVICE = new TicketServiceImpl(TICKET_REPOSITORY);

        USER_REPOSITORY = new UserRepositoryImpl(entityManager);
        USER_SERVICE = new UserServiceImpl(USER_REPOSITORY);
    }

    public static AdminService getAdminService() {
        return ADMIN_SERVICE;
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

    public static UserService getUserService() {
        return USER_SERVICE;
    }
}
