package com.example.supply_chain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location{
	private String address;
	private String country;
	private String pincode;
	private String region;
	private String state;
}
