package util;

import java.sql.Connection;
import java.sql.SQLException;

public class dd {

	public static void main(String[] args) {
		try {
			Connection con = DBUtil.getConnection();
			System.out.println("ㄱㄱ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
