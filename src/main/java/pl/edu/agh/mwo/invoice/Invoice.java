package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
	
	public void addProduct(Product product) {
		
		List<Product> a= new ArrayList<Product>();
		a.add(product);
		
		
		
	}

	public void addProduct(Product product, Integer quantity) {
		
		
		
		
	}

	public BigDecimal getNettotal() {
		
		
		return null;
	}

	public BigDecimal getTax() {
		return null;
	}

	public BigDecimal getGrossTotal() {
		return null;
	}
}
