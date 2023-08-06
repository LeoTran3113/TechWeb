package techweb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import techweb.db.util.TechDBUtil;
import techweb.db.util.TechMyConstant;
import techweb.entity.TechProduct;


public class TechProductService {
	
	public List<TechProduct> getProductsByCategoryId(int categoryId) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TechProduct product = null;

		List<TechProduct> list = new ArrayList<TechProduct>();
		try {
			// make connection to mysql
			conn = TechDBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT * FROM techweb.product where category_id =?");
			ps.setInt(1, categoryId);

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set(IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			while (rs.next()) {
				// rs.next();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				
				product = new TechProduct(id, name, image, price, title, description, categoryId);
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;

	}

	public List<TechProduct> getProductsByName(String productName) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TechProduct product = null;

		List<TechProduct> list = new ArrayList<TechProduct>();
		try {
			// make connection to mysql
			conn = TechDBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT * FROM techweb.product where name like ?");
			ps.setString(1, "%" + productName + "%");

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set(IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				int categoryId = rs.getInt("category_id");
				product = new TechProduct(id, name, image, price, title, description, categoryId);
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	public List<TechProduct> getAllProducts() throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TechProduct product = null;

		List<TechProduct> list = new ArrayList<TechProduct>();
		try {
			// make connection to mysql
			conn = TechDBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT * FROM techweb.product");

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set(IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				int categoryId = rs.getInt("category_id");
				product = new TechProduct(id, name, image, price, title, description, categoryId);
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;
	}

	public List<TechProduct> searchProductByName(String productName) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TechProduct product = null;

		List<TechProduct> list = new ArrayList<TechProduct>();
		try {

			conn = TechDBUtil.makeConnection();
			ps = conn.prepareStatement("SELECT * FROM techweb.product where `name` like ?");
			ps.setString(1, "%" + productName + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				// rs.next();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				int categoryId = rs.getInt("category_id");
				product = new TechProduct(id, name, image, price, title, description, categoryId);
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return list;

	}

	public TechProduct getProductDetails(int productId) throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TechProduct product = null;

		try {
			// make connection to mysql
			conn = TechDBUtil.makeConnection();

			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT * FROM techweb.product where id = ?");
			ps.setInt(1, productId);

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set(IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			if (rs.next()) {
				// rs.next();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				int categoryId = rs.getInt("category_id");
				product = new TechProduct(id, name, image, price, title, description, categoryId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return product;
	}
	public int getTotalPage() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			conn = TechDBUtil.makeConnection();
			ps = conn.prepareStatement("SELECT count(*) as total_page from techweb.product");
			rs = ps.executeQuery();

			if (rs.next()) {
				double totalProduct = rs.getDouble("total_page");
				int totalPage = (int) Math.ceil(totalProduct / TechMyConstant.NUMBER_OF_PRODUCT_IN_ONE_PAGE);
				return totalPage;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return 0;

	}

	public List<TechProduct> getProductByPage(int page) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TechProduct product = null;
		List<TechProduct> list = new ArrayList<TechProduct>();

		try {

			conn = TechDBUtil.makeConnection();
			ps = conn.prepareStatement("select * from techweb.product id limit ?, ? ");
			ps.setInt(1, (page - 1) * TechMyConstant.NUMBER_OF_PRODUCT_IN_ONE_PAGE);
			ps.setInt(2, TechMyConstant.NUMBER_OF_PRODUCT_IN_ONE_PAGE);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int price = rs.getInt("price");
				int categoryId = rs.getInt("category_id");
				product = new TechProduct(id, name, image, price, title, description, categoryId);
				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return list;
	}

}


