package com.asesoftware.semilla.gestorturnos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asesoftware.semilla.gestorturnos.dto.ComercioDTO;
import com.asesoftware.semilla.gestorturnos.dto.ResponseDTO;
import com.asesoftware.semilla.gestorturnos.service.IComercioService;

@RestController
@RequestMapping(path="/api/v1/comercio")
public class ComercioController {
	
	private static final Logger Logger = LoggerFactory.getLogger(ComercioController.class);
	
	@Autowired
	private IComercioService comercioService;
	
	//buscar todos
	@GetMapping(path = "/all")
	public ResponseDTO getAll(){
		Logger.info("Comercio Controller method: getAll");
		return comercioService.getAll();
	}
	
	//buscar por id
	@GetMapping(path = "/comercio/{id}")
	public ResponseDTO getComercioById(@PathVariable Integer id) {	// Parametros en la URL, ej (../usuario?id=1)
		Logger.info("Comercio Controller method: getComercioById");
		Logger.info("Comercio ID to get: {}",id);
		return comercioService.getComercioByID(id);					// Cuando hay 2 params (id, nombre): ../usuario?id=1&nombre=juan
	}
	
	// crear
	@PostMapping(path= "/create", consumes = "application/json", produces = "application/json")
	public ResponseDTO createComercio(@RequestBody ComercioDTO dto) {
		Logger.info("Comercio Controller method: createComercio");
		Logger.info("Comercio entity to create: {}",dto);
		return comercioService.createComercio(dto);
	}
	
	//editar
	@PostMapping(path= "/edit", consumes = "application/json", produces = "application/json")
	public ResponseDTO editComercio(@RequestBody ComercioDTO dto) {
		Logger.info("Comercio Controller method: editComercio");
		Logger.info("Comercio entity to edit: {}",dto);
		return comercioService.updateComercio(dto);
	}
	
	//eliminar
	@DeleteMapping(path = "/delete/{id}")
	public ResponseDTO elimiarComercio(@PathVariable Integer id) { // Parametros en el Path, ej (../usuario/1)
		Logger.info("Comercio Controller method: deleteComercio");
		Logger.info("Comercio ID to delete: {}",id);
		return comercioService.deleteComercio(id);
	}
	
	

}
