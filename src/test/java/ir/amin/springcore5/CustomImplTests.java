package ir.amin.springcore5;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ir.amin.springcore5.data.jpa.flightsample.Flight;
import ir.amin.springcore5.data.jpa.flightsample.FlightRepository;

@DataJpaTest
public class CustomImplTests {
	
	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void shouldSaveCustomImpl() {
		final Flight toDelete = createFlight("London");
		final Flight toKeep = createFlight("Paris");

		flightRepository.save(toDelete);
		flightRepository.save(toKeep);

		flightRepository.deleteByOrigin("London");

		Assertions.assertThat(flightRepository.findAll()).hasSize(1).first().isEqualToComparingFieldByField(toKeep);
	}

	private Flight createFlight(String origin) {
		final Flight flight = new Flight();
		flight.setOrigin(origin);
		flight.setDestination("Tokyo");
		flight.setScheduledAt(LocalDateTime.now());
		return flight;
	}
}
