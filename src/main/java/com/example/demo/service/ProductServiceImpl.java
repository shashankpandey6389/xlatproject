package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	public ProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product prod) {
		// TODO Auto-generated method stub
		return productRepository.save(prod);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return  productRepository.findAll();
	}

	

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Optional<Product> getProduct=productRepository.findById(id);
		productRepository.deleteById(id);
		
	}

	@Override
	public Product getProduct(Integer id) {
		// TODO Auto-generated method stub
		Optional<Product> getProductOptional=productRepository.findById(id);
		return getProductOptional.get();
	}

}