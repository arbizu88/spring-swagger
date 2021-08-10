package com.caha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caha.model.Product;
import com.caha.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags="ProductAPI")//API
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@ApiOperation(value = "Get the list of products", response=Iterable.class) //ApiOperation
	@ApiResponses(value = { //API Responses
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"), 
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
	@GetMapping()
	public List<Product> getAllProducts() {
		return service.getProducts();
	}

	@ApiOperation(value = "Get an specific product", response = Product.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success|OK", response=Product.class),
            @ApiResponse(code = 400, message = "bad request!!!") })
	@GetMapping("/{id}")
	public Product getProduct(@ApiParam(value = "id", example="1") @PathVariable int id) { //ApiParam
		return service.getProduct(id);
	}

	@ApiOperation(value = "Create a new Product ")
	@PostMapping
	public void createProduct(Product product) {
		service.insertProduct(product);
	}

	@ApiOperation(value = "Update a product", response=Product.class)
	@PutMapping
	public Product updateProduct(Product product) {
		return service.updateProduct(product);
	}

	@ApiOperation(value = "Delete a product")
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable int id) {
		Product prd = service.getProduct(id);
		if (prd != null) {
			service.deleteProduct(prd);
		}
	}

}
