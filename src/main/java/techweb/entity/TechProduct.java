package techweb.entity;

import java.util.Objects;



public class TechProduct {

	private int id;
	private String name;
	private String image;
	private int price;
	private String title;
	private String description;
	private int categoryId;

	public TechProduct() {
		// TODO Auto-generated constructor stub
	}

	public TechProduct(int id, String name, String image, int price, String title, String description, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.title = title;
		this.description = description;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, image, price, title, description, categoryId);
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TechProduct other = (TechProduct) obj;
		return id == other.id;
			
	}

}
