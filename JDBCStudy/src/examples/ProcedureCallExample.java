package examples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureCallExample {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	String userID = "hr";
	String userPW = "hr";
	
	public void procedure() {
		
		Connection con = null;
		CallableStatement cstmt = null;
		
		String sql = "{call getEmployee(?, ?, ?, ?)}";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, userID, userPW);
			cstmt = con.prepareCall(sql);
			
			cstmt.setInt(1, 100);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			
			cstmt.execute();
			
			int employeeId = cstmt.getInt(2);
			String firstName = cstmt.getString(3);
			int salary = cstmt.getInt(4);
			System.out.println(employeeId + "\t" + firstName + "\t" + salary);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cstmt != null)
					cstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public static void main(String[] args) {
		ProcedureCallExample pce = new ProcedureCallExample();
		pce.procedure();
	}
}
