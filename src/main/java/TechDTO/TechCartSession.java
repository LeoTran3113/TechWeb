package TechDTO;

import java.util.HashSet;
import java.util.Set;

import techweb.entity.TechProduct;

public class TechCartSession {
		private int userId;
		private Set<TechProduct> products;
		private int totalPrice;

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
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

	
