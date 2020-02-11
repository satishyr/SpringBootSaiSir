package org.st.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.st.model.Product;
import org.st.service.IProductService;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
	@Autowired
	private IProductService service;//HAS-A


	/**
	 * 1. save Product Data
	 * **/
	@PostMapping("/create")
	public ResponseEntity<String> saveProduct(
			@RequestBody Product product) 
	{
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveProduct(product);
			resp=new ResponseEntity<String>("saved with:"+id, HttpStatus.OK);  
		} catch (Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	/***
	 * 2. Fetch All Rows from DB
	 */
	@GetMapping("/all")
	public ResponseEntity<?> getAllProducts() {

		ResponseEntity<?> resp=null;

		try {

			List<Product> list=service.getAllProducts();
			if(list==null || list.isEmpty()) {
				resp = new ResponseEntity<String>("NO DATA FOUND", HttpStatus.OK);
			}else {
				resp = new ResponseEntity<List<Product>>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}

	/***
	 * 3. Remove Record by id
	 */
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeProduct(
			@PathVariable Integer id
			)
	{
		ResponseEntity<String> resp=null;
		try {
			
			service.removeProduct(id);
			resp=new ResponseEntity<String>(id+":Removed successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp=new ResponseEntity<String>(id+":Not Found", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
	/**
	 * 4. Fetch one row by id
	 */
	@GetMapping("/one")
	public ResponseEntity<?> getOneProduct(
			@RequestParam Integer id
			) 
	{
		ResponseEntity<?> resp=null;
		Optional<Product> ob=service.getOneProduct(id);
		if(ob.isPresent()) {
			resp = new ResponseEntity<Product>(ob.get(), HttpStatus.OK);
		}else {
			resp = new ResponseEntity<String>(id+"Data Not Found ", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateProduct(
			@RequestBody Product product
			
			)
	{
		ResponseEntity<String> resp=null;
		Integer id=product.getProdId();
		boolean exist=service.isExist(id);
		if(exist) {
			service.saveProduct(product);
			resp = new ResponseEntity<String>("Updated SuccessFully", HttpStatus.OK);
		}else {
			resp = new ResponseEntity<String>("Data Not Found", HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
	
	
	
	
	
	
	
	
	
	
	
}




