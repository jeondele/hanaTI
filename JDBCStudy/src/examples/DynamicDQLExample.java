package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

//jdbc에 해당하는 것 : connection, statement, resultset
public class DynamicDQLExample {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	String userID = "hr";
	String userPW = "hr";
	
	public void executeSQL(String sql) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, userID, userPW);
			pstmt = con.prepareStatement(sql);
			boolean existRS = pstmt.execute();
			if(existRS) {
				rs = pstmt.getResultSet();
				ResultSetMetaData rsm = rs.getMetaData();
				int colNum = rsm.getColumnCount();
				for (int i = 1; i <= colNum; i++) {
					String colName = rsm.getColumnLabel(i);
					System.out.print(colName +"\t");
				}
				System.out.println();
				while (rs.next()) {
					for (int i = 1; i <= colNum; i++) {
						String colName = rsm.getColumnLabel(i);
						String value = rs.getString(colName);
						System.out.print(value +"\t");
					}
					System.out.println();
				}
			} else {
				int count = pstmt.getUpdateCount();
				System.out.println(count + " 행이 변경되었습니다.");
			}
		} catch (Exception e) {
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		DynamicDQLExample ddq = new DynamicDQLExample();
//		ddq.executeSQL("SELECT * FROM employees");
		ddq.executeSQL("DELETE FROM departments WHERE  department_id = 370");
	}

}
