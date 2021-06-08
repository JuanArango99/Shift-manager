package com.asesoftware.semilla.gestorturnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asesoftware.semilla.gestorturnos.entity.TurnoEntity;
import com.asesoftware.semilla.gestorturnos.service.ITurnoService;

@RestController
@RequestMapping(path = "/api/v1/turno")
public class TurnoController {
	
	@Autowired
	private ITurnoService turnoService;
	
	@GetMapping(path = "/all")
	public List<TurnoEntity> getAll(){
		return turnoService.getAll();
	}
}
