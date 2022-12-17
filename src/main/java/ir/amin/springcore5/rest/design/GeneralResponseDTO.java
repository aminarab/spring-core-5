package ir.amin.springcore5.rest.design;

public class GeneralResponseDTO<T extends AbstractGeneralDTO> {

	private Long id;
	private T dto;
	private String errorCode;
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public T getDto() {
		return dto;
	}

	public void setDto(T dto) {
		this.dto = dto;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}