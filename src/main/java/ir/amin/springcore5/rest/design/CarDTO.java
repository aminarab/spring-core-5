package ir.amin.springcore5.rest.design;

public class CarDTO{

	private Long id;
	private String name;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CarDTO [id=" + id + ", name=" + name + "]";
	}
	
}