package techweb.db.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TechDBUtil {public static Connection makeConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/be_k4", "root",
				"Cost453beta146");
		return conn;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

}
