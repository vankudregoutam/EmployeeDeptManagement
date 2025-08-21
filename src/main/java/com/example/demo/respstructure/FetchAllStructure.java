package com.example.demo.respstructure;

import java.time.LocalDateTime;
import java.util.List;

public class FetchAllStructure<T> {
	
	private int statusCode;
	private LocalDateTime date;
	private List<T> data;
	private String message;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
