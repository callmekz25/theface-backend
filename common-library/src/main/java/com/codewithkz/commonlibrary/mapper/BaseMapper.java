package com.codewithkz.commonlibrary.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaseMapper<E, Req, Res> {
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "createdAt", source = "createdAt")
//    @Mapping(target = "updatedAt", source = "updatedAt")
//    @Mapping(target = "deleted", source = "deleted")
    Res toDTO(E entity);
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "createdAt", source = "createdAt")
//    @Mapping(target = "updatedAt", source = "updatedAt")
//    @Mapping(target = "deleted", source = "deleted")
    E toEntity(Req dto);
    List<E> toEntityList(List<Req> dtoList);
    List<Res> toDTOList(List<E> entityList);

}
