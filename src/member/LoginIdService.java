package member;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.SecurityPassword;

import dao.Action;

public class LoginIdService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String eldd_id = request.getParameter("id");
		String eldd_pw = SecurityPassword.encoding(request.getParameter("pw"));
		
		int returnNum = new MemberDAO().memberCheck(eldd_id, eldd_pw);
		
		if(returnNum == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("id", eldd_id);
			try {
				response.sendRedirect("main.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(returnNum == 0 || returnNum == -1) {
			request.setAttribute("warnMsg", "ID及びPASSWORDをお確認してください。");
			RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
