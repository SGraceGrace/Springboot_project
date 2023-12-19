//package com.example.supply_chain.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.io.InputStream;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.mock.mockito.SpyBean;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.example.supply_chain.model.Photos;
//import com.example.supply_chain.service.impl.PhotoService;
//
//@WebMvcTest(value = PhotoController.class)
//public class PhotosControllerTest {
//
//	@Autowired
//	MockMvc mockMvc;
//
//	@MockBean
//	@SpyBean
//	PhotoService service;
//	
//	@InjectMocks
//	PhotoController control;
//	
//	@Test
//	public void getAllData() throws Exception {
//		
//		String dummyId = "dummyId";
//        Photos dummyPhoto = new Photos();
//        dummyPhoto.setImage("C:\\Users\\GRACE S\\eclipse-workspace1\\supply_chain\\src\\main\\resources\\static\\uploads\\image.jpg");
//        Mockito.when(service.getPhoto(Mockito.anyString())).thenReturn(dummyPhoto);
//
//        ClassPathResource mockResource = Mockito.mock(ClassPathResource.class);
//        InputStream inputStream = Mockito.mock(InputStream.class);
//        Mockito.when(mockResource.getInputStream()).thenReturn(inputStream);
//        Mockito.when(inputStream.readAllBytes()).thenReturn(new byte[0]);
//
//        Mockito.when(new ClassPathResource("static/uploads/" + dummyPhoto.getTitle()+".jpg")).thenReturn(mockResource);
//
//        ResponseEntity<byte[]> response = control.getPhoto(dummyId);
//
//        assertEquals(MediaType.IMAGE_JPEG, response.getHeaders().getContentType());
//	}
//}
