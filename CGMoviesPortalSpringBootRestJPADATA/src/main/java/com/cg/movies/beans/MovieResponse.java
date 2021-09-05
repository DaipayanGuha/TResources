package com.cg.movies.beans;

public class MovieResponse {

	
	private String errorMessage;
	private int statusCode;
	public MovieResponse() {}
	public MovieResponse(String errorMessage, int statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	@Override
	public String toString() {
		return "CustomResponse [errorMessage=" + errorMessage + ", statusCode=" + statusCode + "]";
	}
	
}
