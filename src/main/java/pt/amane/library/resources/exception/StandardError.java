package pt.amane.library.resources.exception;

public class StandardError {

	private Long timestamp;
	private Integer status;
	private String errorMessage;

	public StandardError() {
		super();
	}

	public StandardError(Long timestamp, Integer status, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
