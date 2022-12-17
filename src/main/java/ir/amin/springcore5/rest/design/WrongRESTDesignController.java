package ir.amin.springcore5.rest.design;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
 * Get for show parameter
 * POST for hide parameter
 */
@RestController
@RequestMapping("/ship")
public class WrongRESTDesignController {

	/*
	 * Request : 
	 * http://localhost:8080/ship/read?id=2
	 * 
	 * Response : 
	 * {"id":null,"dto":{"id":2,"name":"benz"},"errorCode":null,"message":null}
	 */
	@RequestMapping("/read")
	public GeneralResponseDTO<ShipDTO> readCar(@RequestParam Long id) {
		ShipDTO carDTO = new ShipDTO();
		carDTO.setId(id);
		carDTO.setName("benz");
		//search by filter
		GeneralResponseDTO<ShipDTO> generalResponseDTO = new GeneralResponseDTO<ShipDTO>(); 
		generalResponseDTO.setDto(carDTO);
		return generalResponseDTO; 
	}
	
	
	/*
	 * Request :
	 * http://localhost:8080/ship/update
	 * {"id":10,"name":"benz"}
	 * 
	 * Response : 
	 * {
		   "id": null,
		   "dto":    {
		      "id": 10,
		      "name": "benz"
		   },
		   "errorCode": null,
		   "message": null
		}
	 * 
	 */
	@RequestMapping(path="/update", method= RequestMethod.POST)
	public GeneralResponseDTO<ShipDTO> updateCar(@RequestBody ShipDTO carDTO) {
		GeneralResponseDTO<ShipDTO> generalResponseDTO = new GeneralResponseDTO<ShipDTO>();
		generalResponseDTO.setDto(carDTO);
		// do update
		return generalResponseDTO;
	}
	
	/*
	 * Request : 
	 * http://localhost:8080/ship/delete
	 * {"id":10,"name":"benz"}
	 * 
	 * Response : 
		{
   			"id": null,
   			"dto":    {
      			"id": 10,
      			"name": "benz"
   			},
   			"errorCode": "327512",
   			"message": "Record Not Found"
		}
	 */
	@RequestMapping(path="/delete" , method= RequestMethod.POST)
	public GeneralResponseDTO<ShipDTO> deleteCar(@RequestBody ShipDTO carDTO) {
		GeneralResponseDTO<ShipDTO> generalResponseDTO = new GeneralResponseDTO<ShipDTO>();
		generalResponseDTO.setDto(carDTO);
		if(carDTO.getName().equalsIgnoreCase("benz")) {
			generalResponseDTO.setErrorCode("327512");
			generalResponseDTO.setMessage("Record Not Found");
		}
		//do delete
		return generalResponseDTO;
	}
	
	/*
	 * Request : 
	 * http://localhost:8080/ship/save
	 * {"id":10,"name":"benz"}
	 * 
	 * Response : 
		{
		   "id": 1,
		   "dto": null,
		   "errorCode": null,
		   "message": null
		}
	 */
	@RequestMapping(path="/save" , method= RequestMethod.POST)
	public GeneralResponseDTO<ShipDTO> saveCar(@RequestBody ShipDTO carDTO) {
		GeneralResponseDTO<ShipDTO> generalResponseDTO = new GeneralResponseDTO<ShipDTO>();
		//do save
		generalResponseDTO.setId(1L);
		return generalResponseDTO;
	}
}