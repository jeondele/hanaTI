package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	private static ResourceBundle resource = null;
	private static DataSource dataSource;
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "hr";
	private static final String password = "hr";
	static {
		setDataSource();
		resource = ResourceBundle.getBundle("conf/sql");
	}
	
	public static void setDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(5);
		dataSource = ds;
	}
	
	public static ResourceBundle getResourceBundle() {
		return resource;
	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
