package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

import util.DBUtil;

public class TodoDao {
	static ResourceBundle sql = DBUtil.getResourceBundle();
	
	public void addTodo(TodoDto dto) {
	}
	
	public List<TodoDto> getTodos() {
		return null;
	}
	
	public int updateTodo(String type, int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		String sqlOne = sql.getString("updateQuery");
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sqlOne);
			
			if(type.equals("DOING")) {
				pstmt.setString(1, "DONE");
			} else if (type.equals("TODO")) {
				pstmt.setString(1, "DOING");
			}
			
			pstmt.setLong(2, id);
			count = pstmt.executeUpdate();
			System.out.println(count + " 개 수정됨");
		} catch (Exception e) {
			
		} finally {
			try {
				DBUtil.close(con, pstmt);
			} catch (Exception e) {}
		}
		return count;
	}
}
