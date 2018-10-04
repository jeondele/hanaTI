package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.dbcp2.BasicDataSource;

public class OracleJdbcUserDAO extends JdbcUserDAO {

	public static final String driver = "oracle.jdbc.OracleDriver";
	public static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String userID = "hr";
	public static final String userPW = "hr";
	
	@Override
	public Connection getConnection() throws Exception {
//		Class.forName(driver);
//        Connection con = DriverManager.getConnection(dbUrl, userID, userPW);
//		return UserConnectionPool.getInstance().getConnection();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(userID);
		dataSource.setPassword(userPW);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		dataSource.setMaxIdle(7);
		
		return dataSource.getConnection();
	}
}
