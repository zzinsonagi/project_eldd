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
				+ " (eldd_id, eldd_pw, eldd_name, eldd_gender, eldd_birth) "
				+ " values "
				+ " (?, ?, ?, ?, ?)";
		
		//성별 전환
		//value 설정하실 때 이름만 여자/남자라고 해놓고서  1, 2라고 넘겨주시는 거면 이 부분은 필요 없습니다!
		String gender = vo.getEldd_gender();
		if(gender.equalsIgnoreCase("여자")) {
			gender = "2";
		}else {
			gender = "1";
		}
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getEldd_id());
			pstmt.setString(2, vo.getEldd_pw());
			pstmt.setString(3, vo.getEldd_name());
			pstmt.setString(4, gender); //그리고 이 부분은 vo.getEldd_gender()로 바꿔야 합니다
			pstmt.setInt(5, vo.getEldd_birth());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(pstmt, conn);
		}
		
	}//makeNewMember()
	
	
	//아이디 중복 확인
	//0으로 리턴되면 아이디가 없는 것이니 회원가입에서 확인용으로도 쓰시면 될듯합니다.
	//1로 리턴되면 아이디가 있는 것입니다.
	//경우에 따라 회원가입 당시 중복 아이디 확인 또는 로그인 때 아이디 확인으로 쓸 수 있습니다
	public int idCheck(String eldd_id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select eldd_id from eldd_member where eldd_id = ?";
		int returnNum = 0;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eldd_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				returnNum = 1;
				return returnNum;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		
		return returnNum;
		
	}//loginCheck() end
	
	
	//비밀번호 확인
	//비밀번호가 일치하면 1, 일치하지 않으면 0을 리턴해줍니다
	public int pwCheck(String eldd_id, String eldd_pw) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select eldd_pw from eldd_member where eldd_id = "+eldd_id;
		int compareA = 0;
		int returnPw = 2;
		
		try {
			
			conn = DBmanager.getIns().getConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				compareA = rs.getInt("eldd_pw");
				if(eldd_pw.equalsIgnoreCase("compareA")) {
					returnPw = 3;
				} else {
					return returnPw;
				}
			} else {
				return returnPw;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}
		return returnPw;
	}

	
}
