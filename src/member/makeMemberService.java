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
		
		MemberDAO dao = new MemberDAO();
		
		String eldd_id = request.getParameter("eldd_id");
		String eldd_pw = request.getParameter("eldd_pw");
		String eldd_name = request.getParameter("eldd_name");
		String eldd_gender = request.getParameter("eldd_gender");
		int eldd_birth = Integer.parseInt(request.getParameter("eldd_birth"));
		
		int returnNum = dao.idCheck(eldd_id);
		
		MemberVO vo = new MemberVO();
		
		vo.setEldd_id(eldd_id);
		vo.setEldd_pw(eldd_pw);
		vo.setEldd_name(eldd_name);
		vo.setEldd_gender(eldd_gender);
		vo.setEldd_birth(eldd_birth);
		
		if(returnNum == 0) {
			dao.makeNewMember(vo);
//			request.setAttribute("returnNum", returnNum);
		} else {
			request.setAttribute("returnNum", returnNum);
		}

	}

}
