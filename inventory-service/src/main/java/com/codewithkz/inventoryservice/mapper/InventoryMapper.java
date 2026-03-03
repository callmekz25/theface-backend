package com.codewithkz.inventoryservice.mapper;


import com.codewithkz.commonlibrary.mapper.BaseMapper;
import com.codewithkz.inventoryservice.dto.InventoryCreateUpdateRequestDTO;
import com.codewithkz.inventoryservice.dto.InventoryCreateUpdateResponseDTO;
import com.codewithkz.inventoryservice.model.Inventory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryMapper extends BaseMapper<Inventory, InventoryCreateUpdateRequestDTO, InventoryCreateUpdateResponseDTO> {
}
