package com.asesoftware.semilla.gestorturnos.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseDTO {

	private Object data;
	private boolean success;
	private String message;
	private HttpStatus status;
	//private Date fechaConsulta;

	public ResponseDTO() {}
	
	public ResponseDTO(Object data, boolean succes, String message, HttpStatus status) {
		this.data = data;
		this.success = succes;
		this.message = message;
		this.status = status;
		//this.fechaConsulta = new Date();
	}
	
	
}
