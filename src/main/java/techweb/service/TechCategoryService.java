package techweb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import techweb.db.util.TechDBUtil;
import techweb.entity.TechCategory;

public class TechCategoryService {
	public List<TechCategory> getAllCategories() throws SQLException {
		// connect to DB
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TechCategory category = null;

		List<TechCategory> categoryList = new ArrayList<TechCategory>();
		try {
			// make connection to mysql

			conn = TechDBUtil.makeConnection();
			// -> table Category ->
			// Run query "select * from category"
			ps = conn.prepareStatement("SELECT * FROM techweb.category;");

			// execute and get result SET
			rs = ps.executeQuery();

			// mapping data in result set(IF RESULT SET HAS DATA) into ENTITY CLASS
			// (Category)
			while (rs.next()) {
				// rs.next();
				int id = rs.getInt("id");
				String name = rs.getString("name");
				category = new TechCategory(id, name);
				categoryList.add(category);
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
		return categoryList;

	}

}
