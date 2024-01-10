package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.notice.noticeDeleteService;
import dao.notice.noticeSelect;
import dao.notice.noticeService;
import dao.notice.noticeUpdateService;
import dao.notice.noticeViewService;

@WebServlet("/")
public class HanulsoController extends HttpServlet {

   private static final long serialVersionUID = 1L;
       
    public HanulsoController() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      doProcess(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      doProcess(request, response);
   }
   
   protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.setCharacterEncoding("utf-8");
      
//      String uri = request.getRequestURI(); // /hanulso/main.do 출력
//      System.out.println(uri);
//      String contextPath = request.getContextPath(); // /hanulso 출력
//      System.out.println(contextPath);
//      String command = uri.substring(contextPath.length()); // / 출력
//      System.out.println(command);
      
      String command = request.getServletPath();
      System.out.println(command);

      String path = null;
      
      if(command.equals("/main.do")||command.equals("/")) {
         path = "Index.jsp";
      } else if(command.equals("/notice.do")) {
         try {
            new noticeSelect().execute(request, response);
            path ="/notice/notice.jsp";
         } catch (Exception e) {
            e.printStackTrace();
         }
      } else if(command.equals("/notice_write.do")) {
            path ="/notice/noticewrite.jsp";
      } else if(command.equals("/notice_insert.do")) {
         try {
            new noticeService().execute(request, response);
            response.sendRedirect("/notice.do");
         } catch (Exception e) {
            e.printStackTrace();
         }
      } else if (command.contentEquals("/noticeview.do")) {
    	  try {
    		  new noticeViewService().execute(request, response);
    		  path = "/notice/notice_view.jsp";
    	  } catch(Exception e){
    		  e.printStackTrace();
    		  }
    	  
      } else if(command.equals("/noticedelete.do")) {
    	  try {
    		  
    		  new noticeDeleteService().execute(request, response);
    		  response.sendRedirect("/notice.do");
    		  
    	  }catch (Exception e) {
			e.printStackTrace();
		}
      } else if(command.equals("/noticemodify.do")) {
    	  try {
    		  
    		  new noticeViewService().execute(request, response);
    		  path = "/notice/noticemodify.jsp";
    		  
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }
      } else if(command.equals("/noticemodifypro.do")) {
    	  try {
    		  
    		  new noticeUpdateService().execute(request, response);
    		  response.sendRedirect("/notice.do");
    		  
    	  }catch(Exception e) {
    		  e.printStackTrace();
    	  }
      }
      
      if(command.equals("/portfolio.do")) {
         path = "/portfolio/Portfolio.jsp";
      } else if(command.equals("/portfolio_insert.do")) {
         path = "/portfolio/portfoliowrite.jsp";
      } else if(command.equals("/qa.do")) {
         path = "/qna/Qa.jsp";
      } else if(command.equals("/faq.do")) {
         path = "/faq/faq.jsp";
      } else if(command.equals("/pds.do")) {
         path = "/pds/pds.jsp";
      } else if(command.equals("/admin.do")) {
         path = "/adm/adm.jsp";
      } 
      
      if(path != null) {
         RequestDispatcher rd = request.getRequestDispatcher(path);
         rd.forward(request, response);
      }
      
      
   }//end

}