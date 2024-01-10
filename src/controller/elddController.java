package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.searchCategoryPage.SearchCategoryPageService;
import dao.searchCategoryPage.SearchSelectedPageService;
import dao.searchPage.SearchPageService;


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
		
		if(command.equals("/")||command.equals("/main.do")||command.equals("/*.do")) {
			path = "/searchPage.do";
		}else if(command.equals("/searchPage.do")) {
			path="/searchPage/searchPage.jsp";
		}else if(command.equals("/searchFoodList.do")) {
			try {
				new SearchPageService().execute(request, response);
				path="/searchPage/searchFoodList.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/searchCategoryPage.do")) {
			try {
				new SearchCategoryPageService().execute(request, response);
				path="/searchCategoryPage/searchCategoryPage.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/selectedCategoryPage.do")) {
			try {
				new SearchSelectedPageService().execute(request, response);
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
