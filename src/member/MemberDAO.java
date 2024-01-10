package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBmanager;

public class MemberDAO {
	
	//회원 생성
	public void makeNewMember(MemberVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into eldd_member "
				+ " (eldd_id, eldd_pw, eldd_lastName, eldd_firstName, eldd_lastYomi, eldd_firstYomi, eldd_gender, eldd_birth) "
				+ " values "
				+ " (?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getEldd_id());
			pstmt.setString(2, vo.getEldd_pw());
			pstmt.setString(3, vo.getEldd_lastName());
			pstmt.setString(4, vo.getEldd_firstName());
			pstmt.setString(5, vo.getEldd_lastYomi());
			pstmt.setString(6, vo.getEldd_firstYomi());
			pstmt.setString(7, vo.getEldd_gender());
			pstmt.setString(8, vo.getEldd_birth());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(pstmt, conn);
		}
		
	}//makeNewMember()
	
	
	public int memberCheck(String id, String pw) {
		
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select eldd_id, eldd_pw from eldd_member where eldd_id = ?";
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("eldd_pw") != null && rs.getString("eldd_pw").equals(pw)) {
					result = 1; //id와 pw 같아서 통과
				} else {
					result = 0; //id는 일치하나 pw만 같지 않을 경우
				}
			} else {
				result = -1; //id가 존재하지 않는 경우
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return result;
	} //memberCheck() end
	

	
}
