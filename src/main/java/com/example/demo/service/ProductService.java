package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;
import com.example.demo.model.User;

public interface ProductService {
	Product saveProduct(Product prod) ;
	List<Product> getAllProduct();
	
	void deleteProduct(Integer id);
	Product getProduct(Integer id);

}
