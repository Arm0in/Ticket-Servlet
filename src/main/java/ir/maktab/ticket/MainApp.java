package ir.maktab.ticket;

import com.github.javafaker.Faker;
import ir.maktab.ticket.domain.*;
import ir.maktab.ticket.domain.enumeration.SeatType;
import ir.maktab.ticket.util.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainApp {
    public static void main(String[] args) {
        extracted();
    }
    private static void extracted() {
        Faker faker = new Faker();
        Passenger passenger = new Passenger("armin", "barghi", "09123456789", LocalDate.of(1999, 9, 9), 5000d);
        passenger.setUsername("armin");
        passenger.setPassword("123");
        passenger.setEmail("armin@gmail.com");
        ApplicationContext.getPassengerService().save(passenger);
        AirLine airLine = new AirLine();
        airLine.setName("Kish Air");
        Admin admin = new Admin("ahmad", "ahmadi", airLine);
        admin.setUsername("admin");
        admin.setPassword("admin");
        ApplicationContext.getAirLineService().save(airLine);
        ApplicationContext.getAdminService().save(admin);
        airLine.setAdmin(admin);
        ApplicationContext.getAirLineService().save(airLine);
        for (int i = 0; i < 5; i++) {
            List<Ticket> tickets = new ArrayList<>();
            LocalDateTime randomDate = faker.date().future(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            Double randomDouble = Double.parseDouble(faker.commerce().price(50d, 1000d));
            Flight flight = new Flight(
                    faker.address().cityName(),
                    faker.address().cityName(),
                    randomDate,
                    randomDate.plusHours(faker.number().numberBetween(2L, 18L)),
                    randomDouble,
                    randomDouble + Double.parseDouble(faker.commerce().price(10d, 100d)),
                    faker.number().numberBetween(10, 50),
                    faker.number().numberBetween(5, 20),
                    airLine,
                    tickets
            );
            ApplicationContext.getFlightService().save(flight);
        }
        for (int i = 0; i < 3; i++) {
            AirLine airLine1 = new AirLine();
            airLine1.setName(faker.company().name());
            ApplicationContext.getAirLineService().save(airLine1);
            Passenger passenger1 = new Passenger(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.phoneNumber().phoneNumber(),
                    faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                    Double.parseDouble(faker.commerce().price(500d, 1000d))
            );
            passenger1.setUsername(faker.name().username());
            passenger1.setPassword(faker.internet().password());
            passenger1.setEmail(faker.internet().emailAddress());
            ApplicationContext.getPassengerService().save(passenger1);
            for (int j = 0; j < 3; j++) {
                Flight flight = new Flight();
                flight.setOrigin(faker.address().cityName());
                flight.setDestination(faker.address().cityName());
                LocalDateTime randomDate = faker.date().future(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                flight.setDepartureTime(randomDate);
                flight.setArrivalTime(randomDate.plusHours(faker.number().numberBetween(2L, 18L)));
                Double randomDouble = Double.parseDouble(faker.commerce().price(50d, 1000d));
                flight.setEconomyCost(randomDouble);
                flight.setBusinessCost(randomDouble + Double.parseDouble(faker.commerce().price(10d, 100d)));
                flight.setEconomySeats(faker.number().numberBetween(10, 30));
                flight.setBusinessSeats(faker.number().numberBetween(10, 30));
                flight.setAirLine(airLine1);
                ApplicationContext.getFlightService().save(flight);
                for (int k = 0; k < 3; k++) {
                    Ticket ticket = new Ticket();
                    ticket.setFlight(flight);
                    ticket.setSeatType(SeatType.typeOf(faker.number().numberBetween(0, 1)));
                    ticket.setCost(ticket.getSeatType().equals(SeatType.ECONOMY) ? ticket.getFlight().getEconomyCost() : ticket.getFlight().getBusinessCost());
                    ticket.setPassenger(passenger1);
//                    ticket.setSeatNumber(faker.number().numberBetween(0l, 20l));
                    ApplicationContext.getTicketService().save(ticket);
                }
            }
        }
    }
}
