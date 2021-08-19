package pt.amane.library.resources.exception;

public class StandardError {

	private String timestamp;
	private Integer status;
	private String errorMessage;

	public StandardError(String timestamp, Integer status, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
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
