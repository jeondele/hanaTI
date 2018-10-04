package examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//jdbc에 해당하는 것 : connection, statement, resultset

/**
 * JDBC API를 이용한 DBMS 연동
 * 
 * @author 전상일
 *
 */
public class JDBCExample {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		String driver = "oracle.jdbc.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String userID = "hr";
		String userPW = "hr";
		// ;(세미콜론)은 sql이 아니기때문에 빼야한다.
		String sql = "SELECT employee_id, last_name, salary\r\n" + "FROM employees\r\n";
//		#1.JDBC 드라이버 로딩(객체 생성)
//		Driver driver = new OracleDriver();

//		Class 클래스를 이용한 동적  객체 생성
//		Class.forName(driver).newInstance(); 뉴 인스턴스까지 해주는 코드가 디폴트로 가지고 있다
		try {
			Class.forName(driver);
//			System.out.println("JDBC 드라이버 생성 완료>....<");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//		#2. DBMS 연결
		try {
			// connection 인터페이스
			con = DriverManager.getConnection(dbUrl, userID, userPW);
//			System.out.println("DBMS 연결 완료..." + con);

//			#3. SQL 서버 전송 및 결과집합 수신
			// statement 인터페이스
			stmt = con.createStatement();
//			System.out.println(stmt);
			// 서버쪽의 커서에 해당하는 인터페이스
			rs = stmt.executeQuery(sql);
//			System.out.println(rs);
//			#4. ResultSet에서 데이터 인출
			while (rs.next()) {
				String id = rs.getString("employee_id");
				String name = rs.getString("last_name");
				int salary = rs.getInt("salary");
				System.out.println(id + "           " + name + "         " + salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

	}

}
