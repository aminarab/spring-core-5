package ir.amin.springcore5.rest.design;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/car/{id}")
public class RightRESTDesignController {

	/*
	 * Request :
	 * http://localhost:8080/car/1
	 * 
	 * Response : 
	 * {"id":1,"name":null}
	 */
	@GetMapping
	public ResponseEntity<CarDTO> readCar(@PathVariable("id") Long id) {
		CarDTO carDTO = new CarDTO();
		carDTO.setId(id);
		return ResponseEntity.ok(carDTO);
	} 
	
	/**
	 * @TODO 
	 */
	@PostMapping
	public Long saveCar(@PathVariable("id") Long id , @RequestBody CarDTO carDTO) {
		//do save
		return 1l;
	}
	
	/**
	 * @TODO 
	 */
	@PutMapping
	public void updateCar(@PathVariable("id") Long id , @RequestBody CarDTO carDTO) {
		//do update
	}
	
	/**
	 * @TODO 
	 */
	@DeleteMapping
	public void deleteCar(@PathVariable("id") Long id , @RequestBody CarDTO carDTO) {
		//do delete
		if(carDTO.getName().equalsIgnoreCase("benz")) {
			ResponseEntity.notFound();
		}
		
	}
	
}