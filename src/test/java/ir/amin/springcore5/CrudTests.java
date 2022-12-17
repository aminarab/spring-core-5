package ir.amin.springcore5;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.assertj.core.api.Assertions;
import ir.amin.springcore5.data.jpa.flightsample.Flight;
import ir.amin.springcore5.data.jpa.flightsample.FlightRepository;

@DataJpaTest
class CrudTests {


	@Autowired
	private FlightRepository flightRepository;

	@Test
	public void shouldPerformCRUDOperations() {
		final Flight flight =  new Flight();
		flight.setOrigin("London");
		flight.setDestination("New York");
		flight.setScheduledAt(LocalDateTime.parse("2011-12-13T12:12:00"));

		flightRepository.save(flight);

		Assertions.assertThat(flightRepository.findAll())
			.hasSize(1)
			.first()
			.isEqualToComparingFieldByField(flight);

		flightRepository.deleteById(flight.getId());

		Assertions.assertThat(flightRepository.count()).isZero();
	}
}
