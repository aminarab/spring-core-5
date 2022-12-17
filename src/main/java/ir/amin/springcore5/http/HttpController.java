package ir.amin.springcore5.http;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ir.amin.springcore5.data.jpa.employeesample.Employee;
import ir.amin.springcore5.data.jpa.employeesample.EmployeeRepository;
import ir.amin.springcore5.scope.RequestComponentBean;

@RestController
@RequestMapping("/http")
public class HttpController {
	

    @Resource(name = "getRequestComponentBean")
	RequestComponentBean requestComponentBean;

	
	@Autowired
	private EmployeeRepository employeeData;

	@GetMapping("/helloworld")
	public String world() {
		System.out.println(requestComponentBean);
		requestComponentBean.doSomeWork();
//		int a = 5/0;
		return  "HelloWorld";
	}

	@GetMapping("/admin")
	public ResponseEntity<Integer> admin() {
		requestComponentBean.doSomeWork();

		return ResponseEntity.ok(2);
	}

	@GetMapping("/admin2")
	public ResponseEntity<Integer> admin2() {
		requestComponentBean.doSomeWork();
		int a = 5 / 0;
		return ResponseEntity.internalServerError().build();
	}

	@GetMapping("/admin3")
	public ResponseEntity<GenericResponse> admin3() {
		requestComponentBean.doSomeWork();
//		int a = 5/0;
		return ResponseEntity.accepted().body(new GenericResponse());
	}

	@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.POST)
	public String newEmployee(Employee employee) {

		employeeData.save(employee);
		return ("redirect:/list.html");

	}

	@RequestMapping(value = "/addNewEmployee.html", method = RequestMethod.GET)
	public ModelAndView addNewEmployee() {

		Employee emp = new Employee();
		return new ModelAndView("newEmployee", "form", emp);

	}

	@RequestMapping(value = "/listEmployees.html", method = RequestMethod.GET)
	public ModelAndView employees() {
		List<Employee> allEmployees = employeeData.findAll();
		return new ModelAndView("allEmployees", "employees", allEmployees);

	}
}
