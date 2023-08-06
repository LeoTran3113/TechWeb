package techweb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import TechDTO.TechCartSession;
import techweb.db.util.TechDBUtil;
import techweb.entity.TechProduct;

public class TechOrderService {
	
	public boolean insertOrderWithItems(TechCartSession cart) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			
			conn = TechDBUtil.makeConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("insert into techweb.`order` (`user_id`, `total_price`) values (?,?)", Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, cart.getUserId());
			ps.setInt(2, cart.getTotalPrice());
			ps.execute(); 
			rs = ps.getGeneratedKeys();

			while (rs.next()) {
				int orderId = rs.getInt(1);
				for (TechProduct product : cart.getProducts()) {
					ps = conn.prepareStatement("insert into techweb.`order_item` (`order_id`, `book_id`,`price`) values (?,?,?)");
					ps.setInt(1, orderId);
					ps.setInt(2, product.getId());
					ps.setInt(3, product.getPrice());
					ps.execute();
				}

			}
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
			return false;
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
		return true;
	}

}
