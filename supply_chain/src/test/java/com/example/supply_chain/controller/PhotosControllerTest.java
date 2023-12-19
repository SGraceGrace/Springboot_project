package com.example.supply_chain.controller;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.multipart.MultipartFile;
import com.example.supply_chain.service.impl.PhotoService;

@WebMvcTest(value = PhotoController.class)
public class PhotosControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	PhotoService service;
	 
	@Test
	public void saveData() throws Exception {
		
		Mockito.when(service.existsId("123")).thenReturn(false);
		Mockito.when(service.addPhoto(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(MultipartFile.class))).thenReturn("1");
		byte[] content=null;
		 
		    mockMvc.perform(MockMvcRequestBuilders.multipart("/photos/add")
		            .file(new MockMultipartFile(
				            "image",         
				            "test.jpg",      
				            "image/jpg", 
				            content 
				    ))
		            .param("photoUid", "123")
		            .param("supplierUid", "456")
		            .param("title", "Test Photo"))
		        .andExpect(MockMvcResultMatchers.status().isCreated());
		        //.andExpect(MockMvcResultMatchers.content().string("Successfully Uploaded"));
		    
		    //verify(service, times(1)).existsId("123");
		    //verify(service, times(1)).addPhoto("123", "456", "Test Photo", imageFile);
    }

}
