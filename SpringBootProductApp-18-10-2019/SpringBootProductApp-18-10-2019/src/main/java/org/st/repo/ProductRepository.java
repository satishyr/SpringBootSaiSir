package org.st.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.st.model.Product;

public interface ProductRepository 
	extends JpaRepository<Product, Integer>
{

}
