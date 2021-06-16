package com.asesoftware.semilla.gestorturnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.semilla.gestorturnos.entity.TurnoEntity;

public interface ITurnoRepository extends JpaRepository<TurnoEntity, Integer>{
	
}
