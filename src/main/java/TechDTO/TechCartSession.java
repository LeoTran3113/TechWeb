package TechDTO;

import java.util.HashSet;
import java.util.Set;

import techweb.entity.TechProduct;

public class TechCartSession {
		private int userId;
		private Set<TechProduct> products;
		private int quantity;
		private int totalPrice;

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public TechCartSession() {
			this.products = new HashSet<TechProduct>();
		}

		public Set<TechProduct> getProducts() {
			return products;
		}

		public void setProducts(Set<TechProduct> products) {
			this.products = products;
		}

		public int getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}

	}

	
