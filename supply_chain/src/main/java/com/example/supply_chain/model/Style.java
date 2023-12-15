package com.example.supply_chain.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(collection="style")
@Data
public class style{
	
	    @Id
        private String _id;
	    public Availability availability;
	    
	    @DBRef
	    @Field("facility_uid")
	    private Facilities facilityUid;
	    
	    @Field("material_composition")
	    private ArrayList<Material> materialComposition;
	    
	    @Field("required_certificate")
	    private String requiredCertificate;
	    
	    private String season;
	    
	    @Field("style_name")
	    private String styleName;
	    
	    @Field("style_number")
	    private String styleNumber;
	    
	    @Field("style_uid")
	    private String styleUid;
	    
	    @DBRef
	    @Field("supplier_uid")
	    private Suppliers supplierUid;
	    
	    private String type;
	    private String year;
	    
	    
	    public class Availability{
	    	
	    	@Getter
	    	@Setter
	    	private String amount;
	    }   
	    
	    @Data
	    public static class Material{
	    	@Field("m_id")
	    	private String mid;
	    	private int composition;
	    }
}
