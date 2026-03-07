package com.codewithkz.productservice.mapper;

import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.productservice.dto.collection.CollectionCreateUpdateRequestDTO;
import com.codewithkz.productservice.dto.collection.CollectionCreateUpdateResponseDTO;
import com.codewithkz.productservice.model.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CollectionMapper extends BaseMapper<Collection, CollectionCreateUpdateRequestDTO, CollectionCreateUpdateResponseDTO> {
}
