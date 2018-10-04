package examples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//jdbc에 해당하는 것 : connection, statement, resultset
public class DQLExample {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String driver = "oracle.jdbc.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String userID = "hr";
		String userPW = "hr";
		
		//여기서 절대 SQL을 짜지마라 SQL Developer 에서!
		String sql = "SELECT e.employee_id     id, \r\n" + 
					"       e.last_name       ename, \r\n" + 
					"       e.salary          salary, \r\n" + 
					"       to_char(e.hire_date, 'YYYY-MM-DD HH24:MI:SS')   hiredate, \r\n" + 
					"       d.department_name dname \r\n" + 
					"FROM   employees e \r\n" + 
					"       join departments d \r\n" + 
					"         ON e.department_id = d.department_id";

		Class.forName(driver);

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		con = DriverManager.getConnection(dbUrl, userID, userPW);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			String id = rs.getString("id");
			String eName = rs.getString("ename");
			int salary = rs.getInt("salary");
			String hireDate = rs.getString("hiredate");
			String dName = rs.getString("dname");
					
			System.out.println(id + ", " + eName + ", " + salary + ", " + hireDate + ", " + dName);
		}
		
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (con != null) con.close();
	}

}
