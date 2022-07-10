package com.brunobandeira.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long error;
	private int message;
	private String path;
	private String status;
	private String timestamp;
	
	public StandardError() {
		
	}

	public StandardError(Long error, int message, String path, String status, String timestamp) {
		super();
		this.error = error;
		this.message = message;
		this.path = path;
		this.status = status;
		this.timestamp = timestamp;
	}

	public Long getError() {
		return error;
	}

	public void setError(Long error) {
		this.error = error;
	}

	public int getMessage() {
		return message;
	}

	public void setMessage(int message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
