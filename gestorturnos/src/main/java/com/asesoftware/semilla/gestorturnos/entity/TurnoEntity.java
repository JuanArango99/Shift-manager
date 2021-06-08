package com.asesoftware.semilla.gestorturnos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "turno")
public class TurnoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fecha_turno")
	private String fecha_turno;
	
	@Column(name = "hora_inicio")
	private String hora_inicio;
	
	@Column(name = "hora_fin")
	private String hora_fin;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@Column(name = "id_servicio")
	private String id_servicio;
	
	
	
	
}
