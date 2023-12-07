package com.example.supply_chain.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection="facilities")
@Data
public class Facilities {
	
    @Id
	private long _id;
    
    private ArrayList<String> certifications;
    
    @Field("created_by")
    private String createdBy;
    
    @Field("facilities_uid")
    private String facilitiesUid;
    
    @Field("facility_name")
    private String facilityName;
    
    private String location;
    private String material;
    
    @Field("supplier_uid")
    private String supplierUid;
    
}
