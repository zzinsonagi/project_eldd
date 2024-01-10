package member;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class makeMemberService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String eldd_id = request.getParameter("id");
		String eldd_pw = request.getParameter("pw");
		String eldd_lastName = request.getParameter("lastname");
		String eldd_firstName = request.getParameter("firstname");
		String eldd_lastYomi = request.getParameter("lastyomi");
		String eldd_firstYomi = request.getParameter("firstyomi");
		String eldd_gender = "";
//		if(request.getParameter("gender").equalsIgnoreCase("male")) {
//			eldd_gender = "M";
//		} else {
//			eldd_gender = "F";
//		}
		String eldd_birth = request.getParameter("year")+request.getParameter("month")+request.getParameter("day");
		
		MemberVO vo = new MemberVO();
		
		vo.setEldd_id(eldd_id);
		vo.setEldd_pw(eldd_pw);
		vo.setEldd_lastName(eldd_lastName);
		vo.setEldd_firstName(eldd_firstName);
		vo.setEldd_lastYomi(eldd_lastYomi);
		vo.setEldd_firstYomi(eldd_firstYomi);
		vo.setEldd_gender(eldd_gender);
		vo.setEldd_birth(eldd_birth);
		
		MemberDAO dao = new MemberDAO();
		dao.makeNewMember(vo);

	}

}
