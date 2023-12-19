package com.example.supply_chain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "photos")
public class Photos {
 
	public Photos(String photoUid , Suppliers supplierUid , String title, String image) {
		this.photoUid=photoUid;
		this.supplierUid=supplierUid;
		this.title=title;
		this.image=image;
	}

	@Id
    private String id;
    
	private String photoUid;
	
	@DocumentReference(collection = "suppliers")
	private Suppliers supplierUid;
	
    private String title;
        
    private String image;
}
