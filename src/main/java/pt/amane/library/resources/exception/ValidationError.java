package pt.amane.library.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
	
	List<FieldMessage> errors = new ArrayList<>();

	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer status, String errorMessage) {
		super(timestamp, status, errorMessage);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	/*
	 * adiciona o erro um por um
	 */
	public void addErrors(String fieldName, String msg) {
		this.errors.add(new FieldMessage(fieldName, msg));
	}
	
	
	
	
	

}
