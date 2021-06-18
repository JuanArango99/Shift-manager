package com.asesoftware.semilla.gestorturnos.mapper;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.asesoftware.semilla.gestorturnos.dto.ServicioDTO;
import com.asesoftware.semilla.gestorturnos.entity.ServicioEntity;

@Mapper(componentModel = "spring")
public interface IServicioMapper {
	
	@Mapping(source = "id_comercio", target = "comercio")
	public ServicioDTO entityToDto(ServicioEntity servicioEntity);
	
	@Mapping(source = "comercio", target = "id_comercio")
	public ServicioEntity dtoToEntity(ServicioDTO servicioDTO);
		
	public List<ServicioDTO> listEntityToDto(List<ServicioEntity> servicioEntity);
	
	public List<ServicioEntity> listDtoToEntity(List<ServicioDTO> servicioDTO);
	
}
