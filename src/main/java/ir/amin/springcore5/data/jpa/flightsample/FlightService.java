package ir.amin.springcore5.data.jpa.flightsample;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public void saveWithoutTransactional() {
		final Flight flight =  new Flight();
		flight.setOrigin("London");
		flight.setDestination("New York");
		flight.setScheduledAt(LocalDateTime.parse("2011-12-13T12:12:00"));
		flightRepository.save(flight);
		throw new RuntimeException("I am failed");
	}
	
	@Transactional
	public void saveWithTransactional() {
		final Flight flight =  new Flight();
		flight.setOrigin("London");
		flight.setDestination("New York");
		flight.setScheduledAt(LocalDateTime.parse("2011-12-13T12:12:00"));
		flightRepository.save(flight);
		throw new RuntimeException("I am failed");
	}
	
}
