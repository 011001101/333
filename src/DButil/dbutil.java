package DButil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class dbutil {
	private static DataSource ds;

	static {
		try {
			Properties prop = new Properties();
			prop.load(dbutil.class.getResourceAsStream("world.properties"));
			
			
			BasicDataSource basic = new BasicDataSource();

			// 데이터 소스의 설정
			basic.setUrl(prop.getProperty("jdbcURL"));
			basic.setDriverClassName(prop.getProperty("jdbcDriverName"));
			basic.setUsername(prop.getProperty("JdbcUserName"));
			basic.setPassword(prop.getProperty("jdbcPassword"));

			ds = basic;

		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
