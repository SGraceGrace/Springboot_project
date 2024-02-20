package com.example.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.model.Product;
import com.example.task.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public String addProduct(Product product) {
		if (!productExists(product.getId())) {
			repo.save(product);
			return "Successfully Added";
		} else {
			return "Already exists";
		}
	}

	public String updateProduct(Product product) {
		if (productExists(product.getId())) {
			Product product2 = Product.builder().id(product.getId()).productName(product.getProductName())
					.quantity(product.getQuantity()).build();

			repo.save(product2);
			return "Updated Successfully";
		} else {
			return "Product not exists";
		}
	}

	public String deleteProduct(String id) {
		if (productExists(id)) {
			repo.deleteById(id);
			return "Deleted";
		} else {
			return "Product not exists";
		}
	}

	public boolean productExists(String id) {
		return repo.existsById(id);
	}
}
