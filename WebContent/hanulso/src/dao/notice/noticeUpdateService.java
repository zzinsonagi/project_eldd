package dao.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Common;

public class noticeUpdateService implements Common {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		noticeVo vo = new noticeVo();
		
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		noticeDao dao = new noticeDao();
		dao.setNoticeUpdate(vo);

	}

}
