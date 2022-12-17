package ir.amin.springcore5.rest.design;

/**
 * @author aminarab
 *
 */
public abstract class AbstractGeneralDTO {

	private Long id;

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "AbstractGeneralDTO [id=" + id + "]";
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
