package com.asesoftware.semilla.gestorturnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asesoftware.semilla.gestorturnos.entity.ComercioEntity;

public interface IComercioRepository extends JpaRepository<ComercioEntity, Integer>{

}
