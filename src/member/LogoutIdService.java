package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Action;

public class LogoutIdService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("id");
		session.invalidate();
		
		try {
			response.sendRedirect("main.do");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
