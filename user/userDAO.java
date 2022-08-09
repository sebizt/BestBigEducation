package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DatabaseUtil;

public class UserDAO {
	public int login(String userId, String userPassword) {
		String SQL = "SELECT userPassword FROM user WHERE userId = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPassword)) {
					return 1; // 
				}
				else {
					return 0; // 
				}
			}
			return -1; // 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) {	e.printStackTrace(); }
		}
		return -2; //db �삤瑜�
	}
	
	public int join(UserDTO user) {
		String SQL = "INSERT INTO user VALUES (?, ?, ?, ?, ?, false)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserNickname());
			pstmt.setString(4, user.getUserEmail());
			pstmt.setString(5, user.getUserEmailHash());
			System.out.println(pstmt);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) {	e.printStackTrace(); }
		}
		return -1; // 
	}
	
	public String getUserNickname(String userId) {
		String SQL = "SELECT userNickname FROM user WHERE userId =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next() ) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) {	e.printStackTrace(); }
		}
		return null; // db �삤瑜�
	}
	public String getUserEmail(String userId) {
		String SQL = "SELECT userEmail FROM user WHERE userId =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next() ) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) {	e.printStackTrace(); }
		}
		return null; // db �삤瑜�
	}
	
	public boolean getUserEmailChecked(String userId) { //
		String SQL = "SELECT userEmailChecked FROM user WHERE userId =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			if(rs.next() ) {
				return rs.getBoolean(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) {	e.printStackTrace(); }
		}
		return false; // db �삤瑜�
	}
	
	public boolean setUserEmailChecked(String userId) { //
		String SQL = "UPDATE user SET userEmailChecked = true  WHERE userId =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userId);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); } catch (Exception e) {	e.printStackTrace(); }
			try { if(rs != null) rs.close(); } catch (Exception e) {	e.printStackTrace(); }
		}
		return false; 
	}


public boolean setUserEmailDuplicate(String userEmail) { //
	String SQL = "select EXISTS (select * from user where userEmail= ? limit 1) as success";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		conn = DatabaseUtil.getConnection();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, userEmail);
		rs = pstmt.executeQuery();
		System.out.println(rs);
		if(rs.next() ) {
			return rs.getBoolean(1);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try { if(conn != null) conn.close(); } catch (Exception e) {	e.printStackTrace(); }
		try { if(pstmt != null) pstmt.close(); } catch (Exception e) {	e.printStackTrace(); }
		try { if(rs != null) rs.close(); } catch (Exception e) {	e.printStackTrace(); }
	}
	return false; // db 
}

}

