package com.example.supply_chain.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<String> addPhoto(@RequestParam("photoUid") String photoUid,@RequestParam("supplierUid") String supplierUid , @RequestParam("title") String title, @RequestParam("image") MultipartFile image) throws IOException {
	    
		try {
			if(photoService.existsId(photoUid) == false) {
			String result = photoService.addPhoto(photoUid ,supplierUid , title, image);
			if(result.equals("1")) {
				return new ResponseEntity<>("Successfully Uploaded",HttpStatus.CREATED);
			}else if(result.equals("0")) {
				return new ResponseEntity<>("FileType Error",HttpStatus.FORBIDDEN);
			}else if(result.equals("-1")) {
				return new ResponseEntity<>("Supplier not Exist",HttpStatus.FORBIDDEN);
			}
			}else {
				return new ResponseEntity<>("Already Exist",HttpStatus.FORBIDDEN);
			}
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
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
	public ResponseEntity<String> update(@RequestParam("photoUid") String photoUid,@RequestParam("supplierUid") String supplierUid , @RequestParam("title") String title, @RequestParam("image") MultipartFile image) throws IOException{
		
		try {
		if(photoService.existsId(photoUid) == true) {
			String result = photoService.updatePhoto(photoUid ,supplierUid , title, image);
			if(result.equals("1")) {
				return new ResponseEntity<>("Successfully Uploaded",HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>("FileType Error",HttpStatus.FORBIDDEN);
			}
		}else {
			return new ResponseEntity<>("File Not Exists",HttpStatus.FORBIDDEN);
		}
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/photos/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) throws IOException {
		
		try {
			if(photoService.existsId(id) == true) {
		        photoService.deletePhoto(id);
		        return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
			}else {
				return new ResponseEntity<>("File Not Exists",HttpStatus.FORBIDDEN);
			}
	}catch(Exception e) {
		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
