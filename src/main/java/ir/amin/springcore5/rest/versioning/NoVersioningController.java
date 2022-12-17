package ir.amin.springcore5.rest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/noversioning")
public class NoVersioningController {

	@GetMapping("/hello")
	public String doSomeWork() {
		return "Hello";
	}
	
}