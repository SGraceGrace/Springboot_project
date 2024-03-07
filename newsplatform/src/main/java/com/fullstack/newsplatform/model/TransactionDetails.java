package com.fullstack.newsplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDetails {

	private String orderId;
	private String currency;
	private Double amount;
}
