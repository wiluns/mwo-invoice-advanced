package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
	private final String name;

	private final BigDecimal price;

	private final BigDecimal taxPercent;

	protected Product(String name, BigDecimal price, BigDecimal tax) throws IllegalArgumentException{
		
if (name==""||name==null|| price==null||price.compareTo(BigDecimal.ZERO)<0 ){
			
			throw new IllegalArgumentException("A message that explains a casue of an exception");
}
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
		
		
		}

	
	public String getName() {
		return name;
	}

	public BigDecimal getPriceWithOutPrice() {
		return price;
	}

	public BigDecimal getTaxPercent() {
		return taxPercent;
	}

	public BigDecimal getPriceWithTax() {
				
		return price.add(price.multiply(taxPercent));
	}
}
