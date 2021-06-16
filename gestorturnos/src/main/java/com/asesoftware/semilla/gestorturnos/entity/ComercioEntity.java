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
@Table(name= "comercio")
public class ComercioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="aforo_maximo")
	private Integer aforo_maximo;
	
	@OneToMany(mappedBy = "id_comercio")
	private List<ServicioEntity> servicio;
	

	
	
	
}
