package ir.amin.springcore5.data.jpa.employeesample;


public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Book id not found : " + id);
    }

}
