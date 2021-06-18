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
import com.asesoftware.semilla.gestorturnos.dto.ResponseDTO;
import com.asesoftware.semilla.gestorturnos.dto.ServicioDTO;
import com.asesoftware.semilla.gestorturnos.service.IServicioService;

@RestController
@RequestMapping(path="/api/v1/servicio")
public class ServicioController {
	
	private static final Logger logger  = LoggerFactory.getLogger(ServicioController.class);
	
	@Autowired
	private IServicioService servicioService;
	
	@GetMapping(path = "/all")
	public ResponseDTO getAll(){
		logger.info("Servicio Controller Method: getAll");
		return servicioService.getAll();
	}
	
	@GetMapping(path = "/servicio/{id}")
	public ResponseDTO getServicioByID(@PathVariable Integer id) {	// Parametros en la URL, ej (../usuario?id=1)
		logger.info("Servicio Controller Method: getServicioByID");
		return servicioService.getServicioByID(id);					// Cuando hay 2 params (id, nombre): ../usuario?id=1&nombre=juan
	}
	
	@GetMapping(path = "/comercio/{id}")
	public ResponseDTO getServicioByComercioID(@PathVariable Integer id) {	// Parametros en la URL, ej (../usuario?id=1)
		logger.info("Servicio Controller Method: getServicioByComercioID");
		return servicioService.getServicioByComercioID(id);					// Cuando hay 2 params (id, nombre): ../usuario?id=1&nombre=juan
	}
	
	// crear
	@PostMapping(path= "/create", consumes = "application/json", produces = "application/json")
	public ResponseDTO createServicio(@RequestBody ServicioDTO dto) {
		logger.info("Servicio Controller Method: createServicio");
		return servicioService.createServicio(dto);
	}
	
	//editar
	@PostMapping(path= "/edit", consumes = "application/json", produces = "application/json")
	public ResponseDTO updateServicio(@RequestBody ServicioDTO dto) {
		logger.info("Servicio Controller Method: updateServicio");
		return servicioService.updateServicio(dto);
	}
	
	//eliminar
	@DeleteMapping(path = "/delete/{id}")
	public ResponseDTO deleteServicio(@PathVariable Integer id) { // Parametros en el Path, ej (../usuario/1)
		logger.info("Servicio Controller Method: deleteServicio");
		return servicioService.deleteServicio(id);
	}
	
}
