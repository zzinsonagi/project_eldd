package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.MainService;
import member.CerCheckService;
import member.EmailCheckService;
import member.IdCheckService;
import member.LoginIdService;
import member.LogoutIdService;
import member.makeMemberService;
import searchCategoryPage.SearchCategoryPageService2;
import searchCategoryPage.SearchSelectedPageService2;
import searchPage.SearchPageService2;
import sub1.Sub1Service;
import sub4.Sub4Service;


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
		} else if(command.equals("/terms.do")) {
			char ran = (char)((Math.random()*26)+65);
			request.setAttribute("ran", ran);
			path = "/Member/terms.jsp";
		} else if(command.equals("/join.do")) {
			String chk = request.getParameter("check");
			System.out.println(chk);
			request.setAttribute("check", chk);
			path = "/Member/join.jsp";
		} else if(command.equals("/idCheck.do")) {
			new IdCheckService().execute(request, response);

		
		
		} else if(command.equals("/emailsend.do")) {
			new EmailCheckService().execute(request, response);
		} else if(command.equals("/certinumber.do")) {
			new CerCheckService().execute(request, response);
		} else if(command.equals("/joinPro.do")) {
			new makeMemberService().execute(request, response);
			//response.sendRedirect("/main.do");
			path = "main.jsp";
			
			
		} else if(command.equals("/login.do")) {
			path = "/Member/login.jsp";
		} else if(command.equals("/loginPro.do")) {
			new LoginIdService().execute(request, response);
		} else if(command.equals("/logout.do")) {
			new LogoutIdService().execute(request, response);
		} else if(command.equals("/searchPage.do")) {
			path="/searchPage/searchPage.jsp";
		} else if(command.equals("/searchFoodList.do")) {
			try {
				new SearchPageService2().execute(request, response);
				path="/searchPage/searchFoodList.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/searchCategoryPage.do")) {
			try {
				new SearchCategoryPageService2().execute(request, response);
				path="/searchCategoryPage/searchCategoryPage.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/selectedCategoryPage.do")) {
			try {
				new SearchSelectedPageService2().execute(request, response);
				path="/searchCategoryPage/searchSelectedCategoryPage.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(path != null) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		
	}//doProcess() end

}
