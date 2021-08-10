package com.caha.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.caha.model.Product;

@Service
public class ProductService {
	
	List<Product> products = new ArrayList<>();
    {
    	products.add(new Product(1, "Coca Cola", new Date(), 500.12));
    	products.add(new Product(2, "Pepsi", new Date(), 350.16));
    	products.add(new Product(3, "Fanta", new Date(), 400.18));
    	products.add(new Product(4, "Imperial", new Date(), 600.13));
    }

	public List<Product> getProducts() {	
		return products;
	}
	
	public void insertProduct(Product product) {
		products.add(product);
	}

	public Product updateProduct(Product prd) {		
		for (Product product : products) {
			if(product.getId() == prd.getId()) {
				products.remove(product);
				products.add(prd);
			}
		}
		return prd;
	}

	public Product getProduct(int id) {
		Product prd = null;
		for (Product product : products) {
			if(product.getId() == id) {
				prd = product;
				break;
			}
		}
		return prd;
	}

	public void deleteProduct(Product prd) {
		List<Product> list = this.getProducts();
		for (Product product : list) {
			if(product.equals(prd)) {
				list.remove(product);
			}
		}
	}
}
