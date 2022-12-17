package ir.amin.springcore5.data.jpa.employeesample;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    // Find
    @GetMapping("/Employees")
    List<Employee> findAll() {
    	if(2==2) {    		
    		throw new IllegalStateException("Tosan");
    	}
    	return repository.findAll();
    }
    

    // Save
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/Employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Find
    @GetMapping("/Employees/{id}")
    Employee findOne(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    // Save or update
    @PutMapping("/Employees/{id}")
    Employee saveOrUpdate(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {
                    x.setName(newEmployee.getName());
                    x.setDept(newEmployee.getDept());
                    return repository.save(x);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    // update author only
    @PatchMapping("/Employees/{id}")
    Employee patch(@RequestBody Map<String, String> update, @PathVariable Long id) {

        return repository.findById(id)
                .map(x -> {

                    String name = update.get("name");
                    if (!StringUtils.isEmpty(name)) {
                    	x.setName(name);

                        // better create a custom method to update a value = :newValue where id = :id
                        return repository.save(x);
                    } else {
                        throw new EmployeeUnSupportedFieldPatchException(update.keySet());
                    }

                })
                .orElseGet(() -> {
                    throw new EmployeeNotFoundException(id);
                });

    }

    @DeleteMapping("/Employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
    


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Exception ex, 
                HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof NullPointerException) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
	
//	@ExceptionHandler(Exception.class)
//	public String handleException(final Exception e) {
//		StringWriter sw = new StringWriter();
//		PrintWriter pw = new PrintWriter(sw);
//		e.printStackTrace(pw);
//		String sStackTrace = sw.toString();
//	    return sStackTrace;
//	    
//	}

}
