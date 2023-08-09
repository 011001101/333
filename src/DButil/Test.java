package DButil;

import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		try {
			dbutil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
