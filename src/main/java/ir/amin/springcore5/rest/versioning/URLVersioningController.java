package ir.amin.springcore5.rest.versioning;

import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@BasePathAwareController
@RestController
@RequestMapping("/urlversioning")
public class URLVersioningController {

	@GetMapping("/hello")
	public String doSomeWork() {
		return "Hello";
	}
}
