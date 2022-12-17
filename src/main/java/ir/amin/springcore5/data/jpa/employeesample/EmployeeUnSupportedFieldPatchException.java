package ir.amin.springcore5.data.jpa.employeesample;

import java.util.Set;

public class EmployeeUnSupportedFieldPatchException extends RuntimeException {

    public EmployeeUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}