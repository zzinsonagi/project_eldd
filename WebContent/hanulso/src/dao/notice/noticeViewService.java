package dao.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Common;

public class noticeViewService implements Common {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		noticeDao dao = new noticeDao();
		noticeVo vo = new noticeVo();
		vo = dao.getIdxView(idx);
		
		request.setAttribute("vo", vo);
		
	}

}
