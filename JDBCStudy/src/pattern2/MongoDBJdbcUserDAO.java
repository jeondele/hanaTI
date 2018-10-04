package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;

public class MongoDBJdbcUserDAO extends JdbcUserDAO {

	public static final String driver = "oracle.jdbc.OracleDriver";
	public static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String userID = "hr";
	public static final String userPW = "hr";
	
	@Override
	public Connection getConnection() throws Exception {
		//MONGO DB에 맞게 Connection 생성 코드....
		return UserConnectionPool.getInstance().getConnection();
		
	}
}
