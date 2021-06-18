package com.asesoftware.semilla.gestorturnos.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asesoftware.semilla.gestorturnos.entity.ServicioEntity;

public interface IServicioRepository extends JpaRepository<ServicioEntity, Integer> {

	
	@Query("SELECT t FROM ServicioEntity t WHERE t.id_comercio =?1 ")
	List<ServicioEntity> queryByComercioId(Integer id_comercio);
		
		
}
