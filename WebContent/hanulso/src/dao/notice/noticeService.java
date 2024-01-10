package dao.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Common;

public class noticeService implements Common {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

      request.setCharacterEncoding("utf-8");
      
      noticeVo vo = new noticeVo();
      
      vo.setTitle(request.getParameter("title"));
      vo.setContent(request.getParameter("content"));
      vo.setWriter(request.getParameter("writer"));
      
      noticeDao dao = new noticeDao();
      
      dao.noticeInsert(vo);

   }

}