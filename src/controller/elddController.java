package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.MainService;
import member.LoginIdService;
import member.LogoutIdService;
import member.makeMemberService;
import sub1.Sub1Service;
import sub4.Sub4Country5Service;
import sub4.Sub4Female5Service;
import sub4.Sub4Male5Service;
import sub4.Sub4Service;
import sub4.Sub4Tot5Service;


@WebServlet("*.do")
public class elddController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public elddController() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doProcess(request, response);
	}//doGet() end

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doProcess(request, response);
	}//doPost() end
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = request.getServletPath();
		String path = null;
		
		//main, sub1, sub4, 회원가입, 로그인 순으로 작성
		if(command.equals("/")||command.equals("/main.do")||command.equals("/*.do")) {
			path = "main.jsp";
		} else if(command.equals("/randomresult.do")) {
			new MainService().execute(request, response);
			path = "randomresult.jsp";
		} else if(command.equals("/sub1.do")) {
			path = "/sub1/sub1.jsp";
		} else if(command.equals("/sub1random.do")) {
			new Sub1Service().execute(request, response);
			path = "/sub1/sub1random.jsp";
		} else if(command.equals("/sub4.do")) {
			new Sub4Service().execute(request, response);
			path = "/sub4/sub4.jsp";
		} else if(command.equals("/sub4Tot5.do")) {
			new Sub4Tot5Service().execute(request, response);
			path = "/sub4/sub4Tot5.jsp";
		} else if(command.equals("/sub4Country5.do")) {
			new Sub4Country5Service().execute(request, response);
			path = "/sub4/sub4Country5.jsp";
		} else if(command.equals("/sub4Female5.do")) {
			new Sub4Female5Service().execute(request, response);
			path = "/sub4/sub4Female5.jsp";
		} else if(command.equals("/sub4Male5.do")) {
			new Sub4Male5Service().execute(request, response);
			path = "/sub4/sub4Male5.jsp";
		} else if(command.equals("/join.do")) {
			new makeMemberService().execute(request, response);
			response.sendRedirect("/login.do");
		} else if(command.equals("/login.do")) {
			path = "/member/login.jsp";
		} else if(command.equals("/loginPro.do")) {
			new LoginIdService().execute(request, response);
		} else if(command.equals("/logout.do")) {
			new LogoutIdService().execute(request, response);
		}
		
		
		if(path != null) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		
	}//doProcess() end

}
