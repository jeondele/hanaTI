package examples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

//jdbc에 해당하는 것 : connection, statement, resultset
public class DMLExample {
	String driver = "oracle.jdbc.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	String userID = "hr";
	String userPW = "hr";
	
	public void create(String departmentName, int managerId, int loc) {
		String mId = "NULL";
		String lId = "NULL";
		if(managerId != 0) {
			mId = managerId+"";
		}
		if(loc != 0) {
			lId = managerId+"";
		}
		//여기서 절대 SQL을 짜지마라 SQL Developer 에서!
		String sql = "INSERT INTO departments \r\n" + 
					 "            (department_id, \r\n" + 
					 "             department_name, \r\n" + 
					 "             manager_id, \r\n" + 
					 "             location_id) \r\n" + 
					 "VALUES      (departments_seq.nextval, \r\n" + 
					 "             '"+ departmentName + "', \r\n" + 
					 "             "+ mId + ", \r\n" + 
					 "             "+ lId +")";

		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, userID, userPW);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			int count = stmt.executeUpdate(sql);
			
			con.commit();
			//실행하면 auto commit
			System.out.println(count + "행이 추가되었습니다...!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public void create2(String departmentName, int managerId, int loc) {
		create3(new Department(0, departmentName, managerId, loc));
	}
	
	public void create3(Department department) {
		//여기서 절대 SQL을 짜지마라 SQL Developer 에서!
		String sql = "INSERT INTO departments \r\n" + 
					 "            (department_id, \r\n" + 
					 "             department_name, \r\n" + 
					 "             manager_id, \r\n" + 
					 "             location_id) \r\n" + 
					 "VALUES      (departments_seq.nextval, ?,?,?)";

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, userID, userPW);
			con.setAutoCommit(false);
			
			//sql 전처리
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, department.getDepartmentName());
			if(department.getDepartmentId() != 0) {
				pstmt.setInt(2, department.getDepartmentId());
			} else {
				pstmt.setNull(2, Types.INTEGER);
			}
			if(department.getLocationId() != 0) {
				pstmt.setInt(3, department.getLocationId());
			} else {
				pstmt.setNull(3, Types.INTEGER);
			}
			
			int count = pstmt.executeUpdate();
			con.commit();
			//실행하면 auto commit
			System.out.println(count + "행이 추가되었습니다...!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}
	}
	
	public void delete (int departmentId) {
		//여기서 절대 SQL을 짜지마라 SQL Developer 에서!
		String sql = "DELETE FROM departments \r\n" + 
					 "WHERE  department_id = ?";

		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbUrl, userID, userPW);
			con.setAutoCommit(false);
			
			//sql 전처리
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, departmentId);
			
			int count = pstmt.executeUpdate();
			con.commit();
			//실행하면 auto commit
			System.out.println(count + "행이 삭제되었습니다...!!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}
	}
	
	public static void main(String[] args) {
		DMLExample dql = new DMLExample();
//		dql.create2("졸리다요", 0, 0);
		dql.delete(390);
	}
}
