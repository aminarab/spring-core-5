package ir.amin.springcore5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ir.amin.springcore5.data.jpa.flightsample.FlightRepository;
import ir.amin.springcore5.data.jpa.flightsample.FlightService;

@SpringBootTest
class JPATransactionTest {


	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private FlightService flightService;
	
	@BeforeEach
	public void setup() {
		flightRepository.deleteAll();
	}
	
	@Test
	public void shouldNotRollbackWhenTheresNoTransaction() {
		try {
			flightService.saveWithoutTransactional();			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Assertions.assertThat(flightRepository.findAll()).isNotEmpty();
		}
	}
	
	@Test
	public void shouldRollbackWhenTheresIsATransaction() {
		try {
			flightService.saveWithTransactional();			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Assertions.assertThat(flightRepository.findAll()).isEmpty();
		}
	}
}
