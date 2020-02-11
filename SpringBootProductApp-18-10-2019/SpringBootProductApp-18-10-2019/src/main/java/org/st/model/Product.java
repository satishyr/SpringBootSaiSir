package org.st.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product implements Comparable<Product>{
	@Id
	@GeneratedValue
	private Integer prodId;
	private String prodCode;
	private Double baseCost;
	private Double discount;
	private Double gst;
	private Double finalCost;
	
	@Override
	public int compareTo(Product o) {
		return this.getProdCode().compareTo(o.getProdCode());
	}
}
