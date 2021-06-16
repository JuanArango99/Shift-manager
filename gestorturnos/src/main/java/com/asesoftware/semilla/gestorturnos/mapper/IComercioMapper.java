package com.asesoftware.semilla.gestorturnos.mapper;

import org.mapstruct.Mapper;

import com.asesoftware.semilla.gestorturnos.dto.ComercioDTO;
import com.asesoftware.semilla.gestorturnos.entity.ComercioEntity;

@Mapper(componentModel = "spring")
public interface IComercioMapper {

	public ComercioEntity dtoToEntity(ComercioDTO dto);
	
	public ComercioDTO entityToDto(ComercioEntity comercioEntity);
	
	
	
}
