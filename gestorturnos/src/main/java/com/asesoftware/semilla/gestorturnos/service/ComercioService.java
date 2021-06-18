package com.asesoftware.semilla.gestorturnos.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.asesoftware.semilla.gestorturnos.dto.ComercioDTO;
import com.asesoftware.semilla.gestorturnos.dto.ResponseDTO;
import com.asesoftware.semilla.gestorturnos.entity.ComercioEntity;
import com.asesoftware.semilla.gestorturnos.mapper.IComercioMapper;
import com.asesoftware.semilla.gestorturnos.repository.IComercioRepository;

@Service
public class ComercioService implements IComercioService {
	
	private static final Logger logger = LoggerFactory.getLogger(ComercioService.class);
	
	@Autowired
	private IComercioRepository comercioRepository;
	
	@Autowired
	private IComercioMapper mapperComercio;

	@Override
	public ResponseDTO getAll() {
		try {
			logger.info("Comercio Service method: getAll");
			return new ResponseDTO(mapperComercio.listEntityToDto(comercioRepository.findAll()),true,"OK",HttpStatus.OK);
		
		} catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null,false,"Comercios not Found",HttpStatus.OK);
		}
		
	}

	@Override
	public ResponseDTO getComercioByID(Integer id) {
		logger.info("Comercio Service method: getComercioByID");
		Optional<ComercioEntity> optional = comercioRepository.findById(id);
		if(optional.isPresent()) {
			logger.info("Comercio with id {} found",id);
			return new ResponseDTO(optional.get(),true,"Comercio Found",HttpStatus.OK);
		}else {
			logger.info("Comercio with id {} not found",id);
			return new ResponseDTO(null,false,"Comercio not Found",HttpStatus.OK);
		}
	}

	@Override
	public ResponseDTO createComercio(ComercioDTO comercioDTO) {
		logger.info("Comercio Service method: createComercio");
		try {
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comercioDTO);
			comercioRepository.save(comercioEntity);
			logger.info("Comercio: {} created",comercioDTO);
			return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "User created", HttpStatus.OK);
			
		}catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, "Comercio not created", null);
		}
	}

	@Override
	public ResponseDTO updateComercio(ComercioDTO comercioDTO) {
		logger.info("Comercio: Service Method: updateComercio");
		try {
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comercioDTO);
			comercioRepository.save(comercioEntity);
			logger.info("Comercio: modified to: {}  ",mapperComercio.entityToDto(comercioEntity));

			return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "comercio edited succesfuly", HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return  new ResponseDTO(null, false, "Comercio not updated", HttpStatus.OK); 
		}		
	}

	@Override
	public ResponseDTO deleteComercio(Integer id) {
		
		logger.info("Comercio: Service Method: deleteComercio");

		try {
			comercioRepository.deleteById(id);
			logger.info("Comercio with ID {} deleted",id);
			return  new ResponseDTO(null, true, "Comercio deleted", HttpStatus.OK); 
			
		} catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			return  new ResponseDTO(null, false, "Comercio could not be deleted", HttpStatus.OK); 
		}
	}
		

}
