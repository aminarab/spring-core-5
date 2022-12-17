package ir.amin.springcore5;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.assertj.core.api.Assertions;


import ir.amin.springcore5.data.jpa.flightsample.Flight;
import ir.amin.springcore5.data.jpa.flightsample.FlightRepository;

@DataJpaTest
public class DerivedQueryTests {
	
    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    public void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    public void shouldFindFlightsFromLondon() {
        final Flight flight1 = createFlight("London");
        final Flight flight2 = createFlight("London");
        final Flight flight3 = createFlight("New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flightsToLondon = flightRepository.findByOrigin("London");

        Assertions.assertThat(flightsToLondon).hasSize(2);
        Assertions.assertThat(flightsToLondon.get(0)).isEqualToComparingFieldByField(flight1);
        Assertions.assertThat(flightsToLondon.get(1)).isEqualToComparingFieldByField(flight2);
    }

    @Test
    public void shouldFindFlightsFromLondonToParis() {
        final Flight flight1 = createFlight("London", "Paris");
        final Flight flight2 = createFlight("London", "New York");
        final Flight flight3 = createFlight("Madrid", "Paris");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        final List<Flight> londonToParis = flightRepository
            .findByOriginAndDestination("London", "Paris");

        Assertions.assertThat(londonToParis)
            .hasSize(1)
            .first()
            .isEqualToComparingFieldByField(flight1);
    }

    @Test
    public void shouldFindFlightsFromLondonOrMadrid() {
        final Flight flight1 = createFlight("London", "New York");
        final Flight flight2 = createFlight("Tokyo", "New York");
        final Flight flight3 = createFlight("Madrid", "New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        final List<Flight> londonOrMadrid = flightRepository
            .findByOriginIn("London", "Madrid");

        Assertions.assertThat(londonOrMadrid).hasSize(2);
        Assertions.assertThat(londonOrMadrid.get(0)).isEqualToComparingFieldByField(flight1);
        Assertions.assertThat(londonOrMadrid.get(1)).isEqualToComparingFieldByField(flight3);
    }

    @Test
    public void shouldFindFlightsFromLondonIgnoringCase() {
        final Flight flight = createFlight("LONDON");

        flightRepository.save(flight);

        final List<Flight> flightsToLondon = flightRepository.findByOriginIgnoreCase("London");

        Assertions.assertThat(flightsToLondon)
            .hasSize(1)
            .first()
            .isEqualToComparingFieldByField(flight);
    }

    private Flight createFlight(String origin, String destination) {
        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setScheduledAt(LocalDateTime.parse("2011-12-13T12:12:00"));
        return flight;
    }

    private Flight createFlight(String origin) {
        return createFlight(origin, "Madrid");
    }
}