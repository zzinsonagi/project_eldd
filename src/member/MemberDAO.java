package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBmanager;

public class MemberDAO {
	
	//회원 생성
	public String makeNewMember(MemberVO vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into eldd_member "
				+ " (eldd_id, eldd_pw, eldd_lastName, eldd_firstName, eldd_lastYomi, eldd_firstYomi, eldd_gender, eldd_birth, eldd_mail) "
				+ " values "
				+ " (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String warnText = "";

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
			pstmt.setString(9, vo.getEldd_mail());
			
			pstmt.executeUpdate();
			warnText = "회원등록이 완료되었습니다.";
			
		} catch (Exception e) {
			e.printStackTrace();
			warnText = "회원등록이 실패했습니다.";
		} finally {
			DBmanager.getIns().close(pstmt, conn);
		}
		return warnText;
		
	}//makeNewMember()
	
	
	//아이디, 비번 체크
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
	
	
	//비동기화식
public int getIdSearch(String id) {
		
		Connection conn = DBmanager.getIns().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select eldd_id from eldd_member where eldd_id = ?";
		
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBmanager.getIns().close(conn, pstmt, rs);
		}

		return result;
	}//getIdSearch() end
	

	//메일 보내기
	public String emailCheck(String email, HttpServletRequest request, HttpServletResponse response) {
		
		String host = "smtp.naver.com";
		String user = "sonagiing@naver.com";
		String password = "Wonder00!";

		String to_email = email;
		
		Properties props = new Properties();
		//Map보다 축소된 기능의 객체. key와 value의 값에 String만 사용한다
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		
		StringBuffer temp = new StringBuffer(); //무작위 문자형 객체만 저장할 수 있는객체 생성
		
		Random rnd = new Random(); //무작위 10진수
		
		for(int i=0; i<10; i++) {
			int rindex = rnd.nextInt(3); //3보다 작은 정수, 0 or 1 or 2 중에서 선택
			switch(rindex) {
			case 0 :
				temp.append((char)((int)(rnd.nextInt(26))+97)); //소문자는 ASCII코드에서 97번째부터 시작
				break;
			case 1 :
				temp.append((char)((int)(rnd.nextInt(26))+65)); //대문자는 ASCII코드에서 65번째부터 시작
				break;
			case 2 :
				temp.append(rnd.nextInt(10)); //숫자 0~9
				break;
			}
		}
		
		String AuthenticationKey = temp.toString(); //인증키
		System.out.println(AuthenticationKey);
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		//smtp 서버 정보와 사용자 정보를 기반으로 Session 객체 생성
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
				//사용자를 인정하고 메시지 저장과 전송에 대한 접근을 제어한다
			}
		});
		
		//메일 보낼 내용 생성
		try {
			
			MimeMessage msg = new MimeMessage(session);
			//제목, 수신자의 이메일 주소, 발송자의 이메일 주소, 보낸 날짜와 같은 실제 이메일 메세지의 세부사항을 나타낸다
			msg.setFrom(new InternetAddress(user, "YouDonggul")); //보내는 사람
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email)); //받는 사람
			msg.setSubject("??? : 컵라면 작은 걸로는 부족하다쨔무, 삼김까지 먹을 수 있다쨔무! 쵸! 배고프다쨔무!");
			msg.setText("키미마로 : "+temp+" << 인증번호를 복사하여 붙여넣기 하십시오.");
			
			Transport.send(msg); //메세지 전송
			
			System.out.println("메일 전송 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return AuthenticationKey;
		
	}//emailSend() end
	
}
