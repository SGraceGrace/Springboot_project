package com.example.supply_chain.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.supply_chain.model.Photos;
import com.example.supply_chain.model.Suppliers;
import com.example.supply_chain.repository.PhotoRepository;
import com.example.supply_chain.repository.SuppliersRepository;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepository photoRepo;
	
	@Autowired
	private SuppliersRepository repo;

	@Value("${upload.folder}")
	String upload;

	public String addPhoto(String photoUid,String supplierUid, String title, MultipartFile file) throws IOException {
		
		Optional<Suppliers> list = repo.findBySupplierUid(supplierUid);
		
		if(list.isPresent()) {
			
		String s = file.getOriginalFilename();
		
		System.out.println(list);
		
		if (isValidFileExtension(s) == true) {
			Photos photo = new Photos(photoUid,list.get(), title, upload + File.separator + file.getOriginalFilename());

			Files.copy(file.getInputStream(), Paths.get(upload + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			photoRepo.save(photo);
			return "Success";
		} else {
			return "Not Accepted";
		}
		}else {
			return "supplier not exist";
		}
	}

	public String updatePhoto(String photoUid, String title, MultipartFile file) throws IOException {

		String s = file.getOriginalFilename();
		
		 Photos existingPhoto = photoRepo.findByPhotoUid(photoUid);
	        
			String oldname = existingPhoto.getTitle();		

	        if (existingPhoto != null && isValidFileExtension(s)) {
	            existingPhoto.setTitle(title);
	            existingPhoto.setImage(upload + File.separator + file.getOriginalFilename());
	            
	            String newname = existingPhoto.getTitle();	

	            photoRepo.save(existingPhoto);

	            Path destination = FileSystems.getDefault().getPath(upload, file.getOriginalFilename());
	            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
	            
	            if(oldname.equals(newname)) {
	            	
	            }else {
	            	deleteImageFile(oldname);
	            }
	            
	            return "Success";
	        } else {
	            return "Not Accepted";
	        }
	}

	public String deletePhoto(String photoUid) throws IOException {

		Photos photo = getPhoto(photoUid);
		
		if (photo != null) {
	        
	        photoRepo.deleteByPhotoUid(photoUid);	        
			deleteImageFile(photo.getTitle());			
			return "Success";
		} else {
			return "Not Accepted";
		}
	}

	private void deleteImageFile(String url) {
		try {
			Path imagePath = Paths.get(upload + "\\" + url + ".jpg" );
			System.out.println(imagePath);
			Files.deleteIfExists(imagePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Photos getPhoto(String id) {
		Optional<Photos> photo = photoRepo.findByphotoUid(id);
		return photo.get();

	}

	private boolean isValidFileExtension(String filename) {
		
		filename = filename.replaceAll("[^.jpg]", "");
		//System.out.println(filename);
	    String allowedExtensionsPattern = ".jpg";

	    return filename.matches(allowedExtensionsPattern);
	}

}