package ir.amin.springcore5;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import ir.amin.springcore5.data.jpa.flightsample.Flight;

@DataJpaTest
class SpringCore5ApplicationTests {
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	void verifyFlightCanBeSave() {
			final Flight flight =new Flight();
			flight.setOrigin("Tehran");
			flight.setOrigin("Kish");
			flight.setScheduledAt(LocalDateTime.parse("2022-12-04T12:13:00"));
			
			entityManager.persist(flight);
			final TypedQuery<Flight> typedQuery = entityManager.createQuery("select f from Flight f", Flight.class);
			List<Flight> resultList = typedQuery.getResultList();
			
			Assertions.assertThat(resultList).hasSize(1).first().isEqualTo(flight);
	}

}
