package pattern3;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

public class UserDAOTest {
	public static final String driver = "oracle.jdbc.OracleDriver";
	public static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String userID = "hr";
	public static final String userPW = "hr";

	public static void main(String[] args) {
		// UserDao 객체 생성
		JdbcUserDAO dao = new JdbcUserDAO();
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(userID);
		dataSource.setPassword(userPW);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		dataSource.setMaxIdle(7);
		
		dao.setDatasource(dataSource);
		
		// 사용자 정보 저장을 위한 도메인 객체 생성
		User user = new User("neo", "네오", "7777", "neo@naver.com", null);

		// UserDao를 이용한 사용자 등록
//		try {
//			dao.create(user);
//			System.out.println(user.getName() + "님 등록 성공!");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println();
//			SQLException ex = (SQLException) e;
//			System.out.println(ex.getErrorCode());
//		}

		// 사용자 정보 조회
//		try {
//			User user2 = dao.read(user.getId());
//			System.out.println(user2.toString() + "조회 완료!");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println();
//			SQLException ex = (SQLException) e;
//			System.out.println(ex.getErrorCode());
//		}

		// 사용자 정보 업데이트
//		try {
//			dao.update(user, "adele");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println();
//			SQLException ex = (SQLException) e;
//			System.out.println(ex.getErrorCode());
//		}

		// 사용자 정보 삭제
//		try {
//			dao.delete(user.getId());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println();
//			SQLException ex = (SQLException) e;
//			System.out.println(ex.getErrorCode());
//		}

		// 사용자 로그인 정보 조회
//		try {
//			User user3 = dao.certify("jeondele", "1234");
//			System.out.println(user3.toString() + " 로그인 가능!");
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println();
//			SQLException ex = (SQLException) e;
//			System.out.println(ex.getErrorCode());
//		}

		// employee list 조회
		try {
			List<Map<String, String>> list = dao.employeeList();
			for (Map<String, String> map : list) {
				System.out.println(map);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
			SQLException ex = (SQLException) e;
			System.out.println(ex.getErrorCode());
		}
		// user 전체 조회
//		try {
//			List<User> list = dao.listAll();
//			for (User userIn : list) {
//				System.out.print(userIn.toString());
//				System.out.println();
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			System.out.println();
//			SQLException ex = (SQLException) e;
//			System.out.println(ex.getErrorCode());
//		}

	}

}
