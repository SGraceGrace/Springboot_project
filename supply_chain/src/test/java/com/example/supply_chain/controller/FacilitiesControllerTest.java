package com.example.supply_chain.controller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.supply_chain.model.Facilities;
import com.example.supply_chain.model.Location;
import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.service.FacilitiesServiceInterface;

@WebMvcTest(value = FacilitiesController.class)
public class FacilitiesControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	@SpyBean
	FacilitiesServiceInterface facility;
	
	@Test
    void getByIdTest() throws Exception {
		
        Facilities sampleFacility = new Facilities("fac123",List.of("None"),"faci1","fac123","gt","chennai","thread",
        		new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material",
        				"Style", "Supplier Name", "12345", "1"));

        when(facility.getById("fac123")).thenReturn(sampleFacility);

        mockMvc.perform(MockMvcRequestBuilders.get("/facilities/select/facilitiesbyId/fac123"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
	void getByIdNotFoundTest() throws Exception {
		Mockito.when(facility.getById("fac123")).thenReturn(null);

		mockMvc.perform(MockMvcRequestBuilders.get("/facilities/select/facilitiesbyId/fac123"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
	
	@Test
	void getAllData() throws Exception {

		List<Facilities> sampleFacility = List.of(new Facilities("fac123",List.of("None"),"faci1","fac123","gt","chennai","thread",
        		new Suppliers("sup123", "sample@email.com", "3", new Location("fd","ghb","vv","uy","hjj"), "Type", "Material",
        				"Style", "Supplier Name", "12345", "1")));

		Mockito.when(facility.getAllData()).thenReturn(sampleFacility);

		mockMvc.perform(MockMvcRequestBuilders.get("/facilities/select/facilities"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getAllDataFoundTest() throws Exception {
		Mockito.when(facility.getAllData()).thenReturn(null);

		mockMvc.perform(MockMvcRequestBuilders.get("/facilities/select/facilities"))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}
