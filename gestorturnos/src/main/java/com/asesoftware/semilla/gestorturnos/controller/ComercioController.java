package com.asesoftware.semilla.gestorturnos.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.asesoftware.semilla.gestorturnos.entity.ComercioEntity;
import com.asesoftware.semilla.gestorturnos.service.IComercioService;

@RestController
@RequestMapping(path="/api/v1/comercio")
public class ComercioController {
	
	private static final Logger Logger = LoggerFactory.getLogger(ComercioController.class);
	
	@Autowired
	private IComercioService comercioService;
	
	//buscar todos
	@GetMapping(path = "/all")
	public List<ComercioEntity> getAll(){
		Logger.info("Controller method: getAll");
		return comercioService.getAll();
	}
	
	//buscar por id
	@GetMapping(path = "/user")
	public ComercioEntity getComercioById(@RequestParam Integer id) {	// Parametros en la URL, ej (../usuario?id=1)
		Logger.info("Controller method: getComercioById");
		Logger.info("Comercio ID to get: {}",id);
		return comercioService.getComercioByID(id);					// Cuando hay 2 params (id, nombre): ../usuario?id=1&nombre=juan
	}
	
	// crear
	@PostMapping(path= "/create", consumes = "application/json", produces = "application/json")
	public ComercioEntity createComercio(@RequestBody ComercioEntity entity) {
		Logger.info("Controller method: createComercio");
		Logger.info("Comercio entity to create: {}",entity);
		return comercioService.createComercio(entity);
	}
	
	//editar
	@PostMapping(path= "/edit", consumes = "application/json", produces = "application/json")
	public ComercioEntity editComercio(@RequestBody ComercioEntity entity) {
		Logger.info("Controller method: editComercio");
		Logger.info("Comercio entity to edit: {}",entity);
		return comercioService.updateComercio(entity);
	}
	
	//eliminar
	@DeleteMapping(path = "/delete/{id}")
	public void elimiarComercio(@PathVariable Integer id) { // Parametros en el Path, ej (../usuario/1)
		Logger.info("Controller method: deleteComercio");
		Logger.info("Comercio ID to delete: {}",id);
		comercioService.deleteComercio(id);
	}
	
	
	

}
