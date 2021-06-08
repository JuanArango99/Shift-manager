package com.asesoftware.semilla.gestorturnos.controller;

import java.util.List;

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
	
	@Autowired
	private IComercioService comercioService;
	
	@GetMapping(path = "/all")
	public List<ComercioEntity> getAll(){
		return comercioService.getAll();
	}
	
	@GetMapping(path = "/usuario")
	public ComercioEntity getComercioParametroById(@RequestParam Integer id) {	// Parametros en la URL, ej (../usuario?id=1)
		return comercioService.getComercioByID(id);					// Cuando hay 2 params (id, nombre): ../usuario?id=1&nombre=juan
	}
	
	// crear
	@PostMapping(path= "/crear", consumes = "application/json", produces = "application/json")
	public ComercioEntity createComercio(@RequestBody ComercioEntity entity) {
		return comercioService.createComercio(entity);
	}
	
	//editar
	@PostMapping(path= "/editar", consumes = "application/json", produces = "application/json")
	public ComercioEntity updateComercio(@RequestBody ComercioEntity entity) {
		return comercioService.updateComercio(entity);
	}
	
	//eliminar
	@DeleteMapping(path = "/delete/{id}")
	public void deleteComercio(@PathVariable Integer id) { // Parametros en el Path, ej (../usuario/1)
		comercioService.deleteComercio(id);
	}
	
	
	

}
