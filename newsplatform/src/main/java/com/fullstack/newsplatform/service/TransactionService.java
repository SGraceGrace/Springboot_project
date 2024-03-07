package com.fullstack.newsplatform.service;

import com.fullstack.newsplatform.model.TransactionDetails;

public interface TransactionService {

	TransactionDetails createTransaction(Double amount);
}
