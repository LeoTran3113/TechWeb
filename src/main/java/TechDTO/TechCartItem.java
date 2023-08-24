package TechDTO;

import java.util.Objects;

import techweb.entity.TechProduct;

public class TechCartItem {
	public String productId;
	public int quantity;
	public TechProduct techProduct;
	public TechCartItem(String productId, int quantity, TechProduct techProduct) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.techProduct = techProduct;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public TechProduct getTechProduct() {
		return techProduct;
	}
	public void setTechProduct(TechProduct techProduct) {
		this.techProduct = techProduct;
	} 
	
	@Override
	public int hashCode() {
		return Objects.hash(productId, quantity, techProduct);
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechCartItem other = (TechCartItem) obj;
		return productId == other.productId;
			
	}


	

}
