package mum.waaproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="File upload errror")
public class FileUploadException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String filename;
	private String message;
	
	public FileUploadException(String filename, String message){
		this.filename = filename;
		this.message  = message;
	}
	
	public String getMessage(){
		return message;
	}
}
