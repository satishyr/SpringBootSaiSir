package org.st.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.st.model.Product;
import org.st.repo.ProductRepository;
import org.st.service.IProductService;

@Service 
//Tx Management+Logics+Calculation
public class ProductServiceImpl 
	implements IProductService
{
	@Autowired
	private ProductRepository repo;//HAS-A

	@Override
	public Integer saveProduct(Product p) {
		double cost=p.getBaseCost();
		double disc=cost*(3/100.0);
		double gst=cost*(8/100.0);
		double fcost=cost-disc+gst;
		//set data to p
		p.setDiscount(disc);
		p.setGst(gst);
		p.setFinalCost(fcost);
		
		//save operation-returns ID(PK)
		Integer id=repo.save(p).getProdId();
		
		return id;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list=repo.findAll();
		//sorting logic
		Collections.sort(list);
		return list;
	}

	@Override
	public void removeProduct(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Product> getOneProduct(Integer id) {
		Optional<Product> prod=repo.findById(id);
		return prod;
	}
	
	@Override
	public boolean isExist(Integer id) {
		return repo.existsById(id);
	}
}




