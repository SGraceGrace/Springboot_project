package com.example.supply_chain.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.supply_chain.model.Location;
import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.repository.SuppliersRepository;

@ExtendWith(MockitoExtension.class)
public class SupplierServiceTest {

	@Mock
	private SuppliersRepository repo;

	@InjectMocks
	SupplierService service;

	@Test
	public void getDataTest() throws Exception {

		List<Suppliers> sampleSupplier = List.of(new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type",
				"Material", "Style", "Supplier Name", "12345", "1"));

		Mockito.when(repo.findAll()).thenReturn(sampleSupplier);

		List<Suppliers> result = service.getAllData();

		assertEquals(sampleSupplier, result);
	}

	@Test
	public void getNullDataTest() throws Exception {

		Mockito.when(repo.findAll()).thenReturn(new ArrayList<>());

		List<Suppliers> result = (service.getAllData());

		assertTrue(result.isEmpty());
	}

	@Test
	public void getByIdTest() throws Exception {

		Suppliers supplier = new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material", "Style",
				"Supplier Name", "12345", "1");

		Optional<Suppliers> sampleSupplier = Optional.of(new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"),
				"Type", "Material", "Style", "Supplier Name", "12345", "1"));

		Mockito.when(repo.findBySupplierUid("sup123")).thenReturn(sampleSupplier);

		Suppliers result = service.getById("sup123");

		assertEquals(supplier, result);
	}

	@Test
	public void getByIdNullTest() throws Exception {

		Mockito.when(repo.findBySupplierUid("sup123")).thenReturn(Optional.ofNullable(null));

		Suppliers result = service.getById("sup123");

		assertNull(result);
	}

	@Test
	public void saveData() {

		Suppliers supplier = new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material", "Style",
				"Supplier Name", "12345", "1");

		Mockito.when(repo.save(supplier)).thenReturn(supplier);

		service.saveData(supplier);

	}

	@Test
	public void updateData() {

		Suppliers supplier = new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material", "Style",
				"Supplier Name", "12345", "1");

		Mockito.when(repo.save(supplier)).thenReturn(supplier);

		service.update(supplier);

	}
	
	@Test
	public void deleteData() {
		
		Suppliers supplier = new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material", "Style",
				"Supplier Name", "12345", "1");
		
		Mockito.when(repo.deleteBySupplierUid("12345")).thenReturn(supplier);

		service.delete("12345");
	}

}
