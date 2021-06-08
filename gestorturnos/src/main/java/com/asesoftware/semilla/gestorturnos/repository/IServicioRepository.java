package com.asesoftware.semilla.gestorturnos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.asesoftware.semilla.gestorturnos.entity.ServicioEntity;

public interface IServicioRepository extends JpaRepository<ServicioEntity, Integer> {

}
