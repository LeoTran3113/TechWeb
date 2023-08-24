package techweb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import techweb.db.util.TechDBUtil;
import techweb.entity.TechUser;



public class TechUserService {
	public boolean insertTechUser(TechUser user) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = TechDBUtil.makeConnection();
			ps = conn.prepareStatement("insert into techweb.`user` (`username`, `password`,`email`) values (?,?,?)");

			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {

			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return true;

	}

}
