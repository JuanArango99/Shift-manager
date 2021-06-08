package com.asesoftware.semilla.gestorturnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.gestorturnos.entity.TurnoEntity;
import com.asesoftware.semilla.gestorturnos.repository.ITurnoRepository;

@Service
public class TurnoService implements ITurnoService{

	@Autowired
	private ITurnoRepository turnoRepository;

	@Override
	public List<TurnoEntity> getAll() {
		return turnoRepository.findAll();
	}
	

}
