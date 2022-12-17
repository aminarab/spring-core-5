package ir.amin.springcore5.rest.design;

public class ShipDTO extends AbstractGeneralDTO{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CarDTO [name=" + name + ", id=" + getId() + "]";
	}

	
}
