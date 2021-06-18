package com.asesoftware.semilla.gestorturnos.service;

import com.asesoftware.semilla.gestorturnos.dto.ComercioDTO;
import com.asesoftware.semilla.gestorturnos.dto.ResponseDTO;

public interface IComercioService {
	
	public ResponseDTO getAll();
	
	public ResponseDTO getComercioByID(Integer id);
	
	public ResponseDTO createComercio(ComercioDTO comercioDTO);
	
	public ResponseDTO updateComercio(ComercioDTO comercioDTO);
	
	public ResponseDTO deleteComercio(Integer id);
	

}
