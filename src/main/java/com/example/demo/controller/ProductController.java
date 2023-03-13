package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;

import com.example.demo.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {
	@Autowired
	public ProductService productService;
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Integer id) {
		Product product = productService.getProduct(id);
		if (product == null) {
			return new ResponseEntity<>("product not found with this id", HttpStatus.BAD_REQUEST);

		} else {
			return new ResponseEntity<>(product, HttpStatus.OK);
		}
	}
	@GetMapping("/getProducts")
	public ResponseEntity<?> getAllProduct(){
		
			return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	
	}
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		productService.saveProduct(product);
		return new ResponseEntity<> ("product added",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		productService.deleteProduct(id);
		return new ResponseEntity<>("product has benn deleted",HttpStatus.OK);
		}

}