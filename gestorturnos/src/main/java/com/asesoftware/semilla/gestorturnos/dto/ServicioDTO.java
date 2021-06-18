package com.asesoftware.semilla.gestorturnos.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ServicioDTO {

	private Integer id;
	
	private String nombre;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss",timezone = "America/New_York")
	private Date hora_apertura;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss",timezone = "America/New_York")
	private Date hora_cierre;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm:ss",timezone = "America/New_York")
	private Date duracion;	
	
	private Integer comercio;
	
	public ServicioDTO() {
		
	}
	
	public ServicioDTO(Integer id,
			String nombre,
			Date hora_apertura,
			Date hora_cierre,
			Date duracion,
			Integer comercio) {
		
		this.id = id;
		this.nombre = nombre;
		this.hora_apertura = hora_apertura;
		this.hora_cierre = hora_cierre;
		this.duracion = duracion;
		this.comercio = comercio;	
		
	}
	
}
