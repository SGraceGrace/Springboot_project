package com.example.supply_chain.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.supply_chain.model.Photos;import com.example.supply_chain.service.impl.PhotoService;

@RestController
public class PhotoController {

	@Autowired
	PhotoService photoService;
	
	@PostMapping("/photos/add")
	public String addPhoto(@RequestParam("photoUid") String photoUid,@RequestParam("supplierUid") String supplierUid , @RequestParam("title") String title, @RequestParam("image") MultipartFile image) throws IOException {
	    String result = photoService.addPhoto(photoUid ,supplierUid , title, image);
	    return result;
	}
	
	@GetMapping("/photos/{id}")
	public ResponseEntity<byte[]> getPhoto(@PathVariable String id) throws IOException {

        Photos photo = photoService.getPhoto(id);
        
        String image = photo.getImage();
        
        int index = image.lastIndexOf('\\');
        
        String url = image.substring(index+1);
		
		ClassPathResource imgFile = new ClassPathResource("static/uploads/" + url);

        byte[] bytes = StreamUtils.copyToByteArray(imgFile.getInputStream());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}
	
	@PutMapping("/photos/update")
	public String update(@RequestParam("photoUid") String photoUid, @RequestParam("title") String title, @RequestParam("image") MultipartFile image) throws IOException{
		
		String result = photoService.updatePhoto(photoUid , title, image);
	    return result;
	}
	
	@DeleteMapping("/photos/delete/{id}")
	public String delete(@PathVariable String id) throws IOException {
		String result = photoService.deletePhoto(id);
	    return result;
	}
}
