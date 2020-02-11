package org.st.service;

import java.util.List;
import java.util.Optional;

import org.st.model.Product;

public interface IProductService {

	public Integer saveProduct(Product p);
	public List<Product> getAllProducts();
	public void removeProduct(Integer id);
	public Optional<Product> getOneProduct(Integer id);
	public boolean isExist(Integer id);
	
}




