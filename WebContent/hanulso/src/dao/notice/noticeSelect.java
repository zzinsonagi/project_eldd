package dao.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Common;

public class noticeSelect implements Common {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
	      
	      noticeDao dao = new noticeDao();
	      List<noticeVo> list = dao.getNotice();
	      int total = dao.getNoticeCount();
	      
	      request.setAttribute("list", list);
	      request.setAttribute("total", total);
	      
	}

}
