package member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class LoginIdService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String eldd_id = request.getParameter("eldd_id");
		String eldd_pw = request.getParameter("eldd_pw");
		
		MemberDAO dao = new MemberDAO();
		
		int returnNum = dao.idCheck(eldd_id);
		
		if(returnNum == 1) {
			int returnPw = dao.pwCheck(eldd_id, eldd_pw);
			request.setAttribute("returnPw", returnPw);
		} else {
			request.setAttribute("returnNum", returnNum);			
		}
		
	}

}
