package com.asesoftware.semilla.gestorturnos.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.gestorturnos.dto.ResponseDTO;
import com.asesoftware.semilla.gestorturnos.dto.ServicioDTO;
import com.asesoftware.semilla.gestorturnos.entity.ServicioEntity;
import com.asesoftware.semilla.gestorturnos.mapper.IServicioMapper;
import com.asesoftware.semilla.gestorturnos.repository.IServicioRepository;

@Service
public class ServicioService implements IServicioService{
	
	private static final Logger logger = LoggerFactory.getLogger(ComercioService.class);
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private IServicioMapper mapperServicio;

	@Override
	public ResponseDTO getAll() {
		logger.info("Servicio Service Method: getAll");
		try {
			logger.info("OK");
			return new ResponseDTO(mapperServicio.listEntityToDto(servicioRepository.findAll()), true, "Servicios found", HttpStatus.OK); 
		} catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null,false,"Servicios not Found",HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO getServicioByID(Integer id) {
		logger.info("Servicio Service Method: getServicioByID");
		Optional<ServicioEntity> optional = servicioRepository.findById(id);
		if(optional.isPresent()) {
			logger.info("Servicio ID {} found",id);
			return new ResponseDTO( optional.get(), true, "Servicio Found",HttpStatus.OK);
		}else {
			logger.info("Servicio ID {} not found",id);
			return new ResponseDTO(null,false,"Servicio not Found",HttpStatus.OK);
		}
	}
	
	public ResponseDTO getServicioByComercioID(Integer id) { // Por lista no hay errores?
		logger.info("Servicio Service Method: getServicioByComercioID");
		try {
			List<ServicioDTO> listServicioDTO = mapperServicio.listEntityToDto(servicioRepository.queryByComercioId(id));
			return new ResponseDTO(listServicioDTO, true, "OK", HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, "Servicio By Comercio ID not found", HttpStatus.OK);

		}
	}


	@Override
	public ResponseDTO createServicio(ServicioDTO servicioDto) {
		logger.info("Servicio Service Method: createServicio");
		try {
			ServicioEntity servicioEntity = mapperServicio.dtoToEntity(servicioDto);
			servicioRepository.save(servicioEntity);
			logger.info("Servicio: {} created",servicioEntity);
			return new ResponseDTO(mapperServicio.entityToDto(servicioEntity),true, "Service created", HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, "Servicio Not created", HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseDTO updateServicio(ServicioDTO servicioDto) {
		logger.info("Servicio Service Method: createServicio");
		try {
			ServicioEntity servicioEntity = mapperServicio.dtoToEntity(servicioDto);
			servicioRepository.save(servicioEntity);
			logger.info("Servicio Modified to: {} ",mapperServicio.entityToDto(servicioEntity));
			return new ResponseDTO(mapperServicio.entityToDto(servicioEntity), true, "Updated", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, "Servicio Not updated", HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO deleteServicio(Integer id) {
		logger.info("Servicio Service Method: deleteServicio");
try {
	servicioRepository.deleteById(id);		
	logger.info("Servicio ID {} deleted",id);
	return new ResponseDTO(null, true, "Comercio deleted", HttpStatus.OK);
	
} catch (Exception e) {
	logger.error("Error {}",e.getMessage());
	return new ResponseDTO(null, false, "Servicio not deleted", HttpStatus.OK);
}

}


}



	
	
	


