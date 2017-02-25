package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.mwo.invoice.product.Product;

	
	
public class Invoice {
	private int number;
public static int numberF=1;
	
	private Map<Product, Integer> products = new HashMap<Product, Integer>();
		

	public void addProduct(Product product) {
		addProduct(product, 1);
	}
	
	public Invoice(){
		this.number=numberF;
		 numberF=numberF+1;
		
	}
	

	public void addProduct(Product product, Integer quantity) {
		if (product == null || quantity <= 0) {
			throw new IllegalArgumentException();
		}
		products.put(product, quantity);
	}

	public BigDecimal getNetTotal() {
		BigDecimal totalNet = BigDecimal.ZERO;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			totalNet = totalNet.add(product.getPrice().multiply(quantity));
		}
		return totalNet;
	}

	public BigDecimal getTaxTotal() {
		return getGrossTotal().subtract(getNetTotal());
	}

	public BigDecimal getGrossTotal() {
		BigDecimal totalGross = BigDecimal.ZERO;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
		}
		return totalGross;
	}

	public int getNumber() {
		return number;
	}

	public String printedVersion() {
		
		String print=String.valueOf(number);
		int liczbaPozycji=0;
		for (Product product : products.keySet()) {
			BigDecimal quantity = new BigDecimal(products.get(product));
			print+="\n"+product.getName()+product.getPrice()+product.getClass()+quantity;
			
			liczbaPozycji=liczbaPozycji+1;
			//System.out.println(product.getName(),product.getPrice(),product.getClass(),quantity);
			
		}
		print=print+"Liczba pozycji "+String.valueOf(liczbaPozycji);
		return print;
	}
}
