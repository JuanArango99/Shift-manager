package com.asesoftware.semilla.gestorturnos.service;
import java.util.List;
import com.asesoftware.semilla.gestorturnos.entity.ServicioEntity;

public interface IServicioService {
	
	public List<ServicioEntity> getAll();
	
	public ServicioEntity getServicioByID(Integer id);
	
	public ServicioEntity createServicio(ServicioEntity servicioEntity);
	
	public ServicioEntity updateServicio(ServicioEntity servicioEntity);
	
	public void deleteServicio(Integer id);

}
