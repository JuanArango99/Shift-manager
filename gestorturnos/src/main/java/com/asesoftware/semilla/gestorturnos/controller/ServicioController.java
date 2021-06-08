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
import com.asesoftware.semilla.gestorturnos.entity.ServicioEntity;
import com.asesoftware.semilla.gestorturnos.service.IServicioService;

@RestController
@RequestMapping(path="/api/v1/servicio")
public class ServicioController {

	@Autowired
	private IServicioService servicioService;
	
	@GetMapping(path = "/all")
	public List<ServicioEntity> getAll(){
		return servicioService.getAll();
	}
	
	@GetMapping(path = "/usuario")
	public ServicioEntity getServicioByID(@RequestParam Integer id) {	// Parametros en la URL, ej (../usuario?id=1)
		return servicioService.getServicioByID(id);					// Cuando hay 2 params (id, nombre): ../usuario?id=1&nombre=juan
	}
	
	// crear
	@PostMapping(path= "/crear", consumes = "application/json", produces = "application/json")
	public ServicioEntity createServicio(@RequestBody ServicioEntity entity) {
		return servicioService.createServicio(entity);
	}
	
	//editar
	@PostMapping(path= "/editar", consumes = "application/json", produces = "application/json")
	public ServicioEntity updateServicio(@RequestBody ServicioEntity entity) {
		return servicioService.updateServicio(entity);
	}
	
	//eliminar
	@DeleteMapping(path = "/delete/{id}")
	public void deleteServicio(@PathVariable Integer id) { // Parametros en el Path, ej (../usuario/1)
		servicioService.deleteServicio(id);
	}
	
}
