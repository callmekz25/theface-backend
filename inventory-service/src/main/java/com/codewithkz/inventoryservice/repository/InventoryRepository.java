package com.codewithkz.inventoryservice.repository;

import com.codewithkz.commonlibrary.repository.BaseRepository;
import com.codewithkz.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends BaseRepository<Inventory, String> {
    Optional<Inventory> getByVariantId(String variantId);
}
