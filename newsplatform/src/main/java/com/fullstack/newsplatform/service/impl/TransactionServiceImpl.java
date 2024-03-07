package com.fullstack.newsplatform.service.impl;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fullstack.newsplatform.model.TransactionDetails;
import com.fullstack.newsplatform.service.TransactionService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class TransactionServiceImpl implements TransactionService{

	private final String KEY = "rzp_test_KakeVejLALLeSY";
	private final String SECRET_KEY = "zJWQDYHJjuW0bXFedcoL0t7b";
	private final String CURRENCY = "INR";
	
	public TransactionDetails createTransaction(Double amount) {
		
		try {
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("amount", amount * 100);
			jsonObject.put("currency", CURRENCY);
			
			RazorpayClient razorpayClient = new RazorpayClient(KEY, SECRET_KEY);
			
			Order order = razorpayClient.orders.create(jsonObject);
			
			return prepareTransactionDetails(order);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private TransactionDetails prepareTransactionDetails(Order order) {
		String orderId = order.get("id");
		String currency = order.get("currency");
		Double amount = order.get("amount");
		
		TransactionDetails transactionDetails = new TransactionDetails(orderId, currency, amount);
		
		return transactionDetails;
	}
}
