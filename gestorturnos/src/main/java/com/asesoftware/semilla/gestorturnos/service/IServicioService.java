package com.asesoftware.semilla.gestorturnos.service;
import com.asesoftware.semilla.gestorturnos.dto.ResponseDTO;
import com.asesoftware.semilla.gestorturnos.dto.ServicioDTO;

public interface IServicioService {
	
	public ResponseDTO getAll();
	
	public ResponseDTO getServicioByID(Integer id);
	
	public ResponseDTO getServicioByComercioID(Integer id);
	
	public ResponseDTO createServicio(ServicioDTO dto);
	
	public ResponseDTO updateServicio(ServicioDTO dto);
	
	public ResponseDTO deleteServicio(Integer id);

}
