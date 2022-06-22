package it.beije.turing.settemmezzo.exception;

import java.time.LocalDateTime;


public class ErrorMessage {
	
	private String time;
	private String status;
	private String message;

	public String getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time.toString();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = Integer.toString(status);
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}