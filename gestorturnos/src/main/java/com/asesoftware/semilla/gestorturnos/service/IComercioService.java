package com.asesoftware.semilla.gestorturnos.service;
import java.util.List;
import com.asesoftware.semilla.gestorturnos.entity.ComercioEntity;

public interface IComercioService {
	
	public List<ComercioEntity> getAll();
	
	public ComercioEntity getComercioByID(Integer id);
	
	public ComercioEntity createComercio(ComercioEntity comercioEntity);
	
	public ComercioEntity updateComercio(ComercioEntity comercioEntity);
	
	public void deleteComercio(Integer id);
	

}
