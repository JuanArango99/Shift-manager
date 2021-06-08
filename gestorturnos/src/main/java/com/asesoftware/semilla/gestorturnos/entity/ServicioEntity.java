package com.asesoftware.semilla.gestorturnos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "servicio")
public class ServicioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "hora_apertura")
	private String hora_apertura;
	
	@Column(name = "hora_cierre")
	private String hora_cierre;
	
	@Column(name = "duracion")
	private String duracion;
	
	@Column(name = "id_comercio")
	private Integer id_comercio;
	
	@OneToMany(mappedBy = "id_servicio")
	private List<TurnoEntity> turno;
	
	
	

	
	
	
	
	 



	
	
}
