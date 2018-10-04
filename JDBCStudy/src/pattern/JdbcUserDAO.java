package pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class JdbcUserDAO implements UserDAO{

	public static final String driver = "oracle.jdbc.OracleDriver";
	public static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String userID = "hr";
	public static final String userPW = "hr";
	
	@Override
	public void create(User user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO users \r\n" + 
					 "            (id, \r\n" + 
					 "             NAME, \r\n" + 
					 "             passwd, \r\n" + 
					 "             email, \r\n" + 
					 "             regdate) \r\n" + 
					 "VALUES      (?, \r\n" + 
					 "             ?, \r\n" + 
					 "             ?, \r\n" + 
					 "             ?, \r\n" + 
					 "             SYSDATE) ";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			
			int count = pstmt.executeUpdate();
			con.commit();
			System.out.println(count + "행이 삽입되었습니다.");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}
	}

	@Override
	public User read(String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		
		String sql = "SELECT id, \r\n" + 
					 "       name, \r\n" + 
					 "       passwd, \r\n" + 
					 "       email, \r\n" + 
					 "       regdate \r\n" + 
					 "FROM   users \r\n" + 
					 "WHERE  id = ? ";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setDate(rs.getString("regdate"));
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}
		return user;
	}

	@Override
	public void update(User user, String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE users\r\n" + 
					 "SET name = ?, passwd = ?, email = ?, regdate = sysdate\r\n" + 
					 "WHERE id = ?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPasswd());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, id);
			int count = pstmt.executeUpdate();
			con.commit();
			System.out.println(count + "행이 업데이트되었습니다.");
		
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}
	}

	@Override
	public void delete(String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM users \r\n" + 
					 "WHERE  id = ?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			int count = pstmt.executeUpdate();
			con.commit();
			System.out.println(count + "행이 삭제되었습니다.");
		
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}
	}

	@Override
	public User certify(String id, String passwd) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		
		String sql = "SELECT * \r\n" + 
					 "FROM   users \r\n" + 
					 "WHERE  id = ? \r\n" + 
					 "       AND passwd = ?";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setDate(rs.getString("regdate"));
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}
		return user;
	}

	@Override
	public List<User> listAll() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new Vector<User>();
		User user = null;
		
		String sql = "SELECT * \r\n" + 
					 "FROM   users ";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setDate(rs.getString("regdate"));
				list.add(user);
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}
		return list;
	}

	/*사원번호, 사원이름, 급여, 부서이름, 도시명 컬럼값을 가지는 employee list를 가져와야 한다.*/
	@Override
	public List<Map<String, String>> employeeList() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT e.employee_id     id, \r\n" + 
					"       e.last_name       NAME, \r\n" + 
					"       e.salary          sal, \r\n" + 
					"       d.department_name dName, \r\n" + 
					"       l.city            city \r\n" + 
					"FROM   employees e \r\n" + 
					"       LEFT OUTER JOIN departments d \r\n" + 
					"                    ON e.department_id = d.department_id \r\n" + 
					"       LEFT OUTER JOIN locations l \r\n" + 
					"                    ON d.location_id = l.location_id \r\n" + 
					"ORDER  BY id ASC";
		
		Map<String, String> empList = null;
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
			
			int colNum = rsm.getColumnCount();
			
			while (rs.next()) {
				empList = new HashMap<String, String>();
				for (int i = 1; i <= colNum; i++) {
					String colName = rsm.getColumnLabel(i);
					String value = rs.getString(colName);
					empList.put(colName, value);
				}
				list.add(empList);
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {}
		}
		return list;
	}

	@Override
	public Connection getConnection() throws Exception {
		Class.forName(driver);
        Connection con = DriverManager.getConnection(dbUrl, userID, userPW);
        return con;
	}

	
	
}
