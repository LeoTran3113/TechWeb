package techweb.entity;

public class TechOrderItem {
	private int id;
	private int orderId;
	private int productId;
	private int price;
	public TechOrderItem(int id, int orderId, int productId, int price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.price = price;
	}
	public TechOrderItem() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
