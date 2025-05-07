package com.productinventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productinventory.model.Inventory;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, Integer>{


	Optional<Inventory> findByProductId(int productId);
}
