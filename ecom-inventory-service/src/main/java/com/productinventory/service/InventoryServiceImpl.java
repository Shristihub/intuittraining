package com.productinventory.service;

import org.springframework.stereotype.Service;

import com.productinventory.exceptions.IdNotFoundException;
import com.productinventory.model.Inventory;
import com.productinventory.repository.IInventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements IInventoryService{
	
	private final IInventoryRepository inventoryRepository;

	@Override
	public String addStock(int productId, int stock) {
//		check if productId is available in the database
//		if available return that inventory object
		Inventory inventory =  
				inventoryRepository.findByProductId(productId)
//		else create the new inventory object
				.orElseGet(()-> new Inventory());
		inventory.setProductId(productId);
		inventory.setStock(inventory.getStock()+stock);
		inventoryRepository.save(inventory);
		return "stock added";
	}

	@Override
	public String updateStock(int productId, int stock) {
//		check if productId is available in the database
//		if available return that inventory object
		Inventory inventory =  
				inventoryRepository.findByProductId(productId)
//		else throw exception
				.orElseThrow(()-> new IdNotFoundException("invalid id"));
		inventory.setProductId(productId);
		inventory.setStock(inventory.getStock()+stock);
		inventoryRepository.save(inventory);
		return "stock updated";
	}

	@Override
	public int checkStock(int productId) {
		Inventory inventory =  
				inventoryRepository.findByProductId(productId)
//		else throw exception
				.orElseThrow(()-> new IdNotFoundException("invalid id"));
		return inventory.getStock();
	}

}
