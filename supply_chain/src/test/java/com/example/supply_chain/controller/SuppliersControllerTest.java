package com.example.supply_chain.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.supply_chain.model.Location;
import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.service.SupplierServiceInterface;

@WebMvcTest(value = SuppliersController.class)
public class SuppliersControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	@SpyBean
	SupplierServiceInterface supplier;

	@Test
	void getByIdTest() throws Exception {
		Suppliers sampleSupplier = new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material",
				"Style", "Supplier Name", "12345", "1");

		Mockito.when(supplier.getById("12345")).thenReturn(sampleSupplier);

		mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/select/suppliersbyId/12345"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getByIdNotFoundTest() throws Exception {
		Mockito.when(supplier.getById("12345")).thenReturn(null);

		mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/select/suppliersbyId/12345"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	void getAllData() throws Exception {

		List<Suppliers> sampleSupplier = List.of(new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type",
				"Material", "Style", "Supplier Name", "12345", "1"));

		Mockito.when(supplier.getAllData()).thenReturn(sampleSupplier);

		mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/select/suppliers"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getAllDataFoundTest() throws Exception {
		Mockito.when(supplier.getAllData()).thenReturn(null);

		mockMvc.perform(MockMvcRequestBuilders.get("/suppliers/select/suppliers"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	void insertData() throws Exception {

		Suppliers sampleSupplier = new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material",
				"Style", "Supplier Name", "12345", "1");

		Mockito.doNothing().when(supplier).saveData(sampleSupplier);

		mockMvc.perform(MockMvcRequestBuilders.post("/suppliers/save/suppliers").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "  \"_id\": \"sup123\",\r\n"
						+ "  \"emailId\": \"sample@email.com\",\r\n"
						+ "  \"facilities\": \"3\",\r\n"
						+ "  \"location\": {\r\n"
						+ "    \"address\": \"fd\",\r\n"
						+ "    \"country\": \"ghb\",\r\n"
						+ "    \"pincode\": \"vv\",\r\n"
						+ "    \"region\": \"uy\",\r\n"
						+ "    \"state\": \"hjj\"\r\n"
						+ "  },\r\n"
						+ "  \"materialType\": \"Type\",\r\n"
						+ "  \"rawMaterial\": \"Material\",\r\n"
						+ "  \"styles\": \"Style\",\r\n"
						+ "  \"supplierName\": \"Supplier Name\",\r\n"
						+ "  \"supplierUid\": \"12345\",\r\n"
						+ "  \"tier\": \"1\"\r\n"
						+ "}\r\n"
						+ "}"))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void updateData() throws Exception {

		Suppliers sampleSupplier = new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material",
				"Style", "Supplier Name", "12345", "1");

		Mockito.when(supplier.existId("12345")).thenReturn(true);

		Mockito.doNothing().when(supplier).update(sampleSupplier);

		mockMvc.perform(MockMvcRequestBuilders.put("/suppliers/update/supplier").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "  \"_id\": \"sup123\",\r\n"
						+ "  \"emailId\": \"sample@email.com\",\r\n"
						+ "  \"facilities\": \"3\",\r\n"
						+ "  \"location\": {\r\n"
						+ "    \"address\": \"fd\",\r\n"
						+ "    \"country\": \"ghb\",\r\n"
						+ "    \"pincode\": \"vv\",\r\n"
						+ "    \"region\": \"uy\",\r\n"
						+ "    \"state\": \"hjj\"\r\n"
						+ "  },\r\n"
						+ "  \"materialType\": \"Type\",\r\n"
						+ "  \"rawMaterial\": \"Material\",\r\n"
						+ "  \"styles\": \"Style\",\r\n"
						+ "  \"supplierName\": \"Supplier Name\",\r\n"
						+ "  \"supplierUid\": \"12345\",\r\n"
						+ "  \"tier\": \"1\"\r\n"
						+ "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void updateDataNotExist() throws Exception {

		Suppliers sampleSupplier = new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material",
				"Style", "Supplier Name", "12345", "1");

		Mockito.when(supplier.existId("12346")).thenReturn(false);

		Mockito.doNothing().when(supplier).update(sampleSupplier);

		mockMvc.perform(MockMvcRequestBuilders.put("/suppliers/update/supplier").contentType(MediaType.APPLICATION_JSON)
				.content(
						"{\r\n"
						+ "  \"_id\": \"sup123\",\r\n"
						+ "  \"emailId\": \"sample@email.com\",\r\n"
						+ "  \"facilities\": \"3\",\r\n"
						+ "  \"location\": {\r\n"
						+ "    \"address\": \"fd\",\r\n"
						+ "    \"country\": \"ghb\",\r\n"
						+ "    \"pincode\": \"vv\",\r\n"
						+ "    \"region\": \"uy\",\r\n"
						+ "    \"state\": \"hjj\"\r\n"
						+ "  },\r\n"
						+ "  \"materialType\": \"Type\",\r\n"
						+ "  \"rawMaterial\": \"Material\",\r\n"
						+ "  \"styles\": \"Style\",\r\n"
						+ "  \"supplierName\": \"Supplier Name\",\r\n"
						+ "  \"supplierUid\": \"12345\",\r\n"
						+ "  \"tier\": \"1\"\r\n"
						+ "}"))
				.andExpect(MockMvcResultMatchers.status().isForbidden());
	}

	@Test
	void deleteSupplierTest() throws Exception {

		Mockito.when(supplier.existId("12345")).thenReturn(true);

		Mockito.doNothing().when(supplier).delete("12345");

		mockMvc.perform(MockMvcRequestBuilders.delete("/suppliers/delete/supplier/12345"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void deleteSupplierNotExistTest() throws Exception {

		Mockito.when(supplier.existId("12346")).thenReturn(false);

		Mockito.doNothing().when(supplier).delete("12346");

		mockMvc.perform(MockMvcRequestBuilders.delete("/suppliers/delete/supplier/12346"))
				.andExpect(MockMvcResultMatchers.status().isForbidden());
	}
}
