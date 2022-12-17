package ir.amin.springcore5.scope;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scopes")
public class ScopesController {
	
    @Resource(name = "getRequestPOJOBean")
    RequestPOJOBean requestPOJOBeanByResource;

    @Resource(name = "getRequestComponentBean")
    RequestComponentBean requestComponentBeanByResource;

    @Autowired
    RequestPOJOBean requestPOJOBean;
    
//    Unsatisfied dependency expressed through field 'requestComponentBean'
//    @Autowired (required = false)
//    RequestComponentBean requestComponentBean;
    
    
    
	@GetMapping("/requestBeans")
	public String requestBeans() {
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("<p>requestPOJOBean hash code : " + requestPOJOBean.hashCode() + "</p>");
//		responseBuilder.append("<p>requestComponentBean : " + requestPOJOBean + "</p>");
		responseBuilder.append("<p>requestPOJOBeanByResource hash code : " + requestPOJOBeanByResource.hashCode()+ "</p>");
		responseBuilder.append("<p>requestComponentBeanByResource hash code : " + requestComponentBeanByResource.hashCode()+ "</p>");
		requestPOJOBeanByResource.doSomeWork();
		return responseBuilder.toString();
	}

}
