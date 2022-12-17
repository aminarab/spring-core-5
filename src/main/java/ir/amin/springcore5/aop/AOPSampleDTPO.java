package ir.amin.springcore5.aop;

public class AOPSampleDTPO {

	private String firstName;
	private String lastName;
	private Boolean needToException = false;
	
	
	public Boolean getNeedToException() {
		return needToException;
	}

	public void setNeedToException(Boolean needToException) {
		this.needToException = needToException;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "AOPSampleDTPO [firstName=" + firstName + ", lastName=" + lastName + ", needToException="
				+ needToException + "]";
	}

}
