package techweb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import techweb.db.util.TechDBUtil;
import techweb.entity.TechAccount;


public class TechLoginService {
	public TechAccount login(String user, String pass) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		

		try {
			String query = "SELECT * FROM be_k4.account where username = ? and password = ?";
			conn = TechDBUtil.makeConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String usernname = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				
				TechAccount acc = new TechAccount(id, usernname, password, email);
				
				return acc;
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
		return null;
	}


}
