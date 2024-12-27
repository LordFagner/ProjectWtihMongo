package com.fagcorps.main.Resource.Expection;

import java.io.Serializable;
import java.time.Instant;

public class StandErrorMongo  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private Instant timestamp;
	private Integer status; 
	private String message;
	private String  error ;
	private String path ;
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public StandErrorMongo(Instant instant, int i, String string, String error2, String string2) {
		this.timestamp = instant;
		this.status = i;
		this.message = string;
		this.error = error2;
		this.path = string2;
		// TODO Auto-generated constructor stub
	}
	public StandErrorMongo() {
		// TODO Auto-generated constructor stub
	} 

	

}
