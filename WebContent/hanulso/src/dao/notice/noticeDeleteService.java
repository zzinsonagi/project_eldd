package dao.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Common;

public class noticeDeleteService implements Common {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		
		//클라이언트로부터 처리하고자하는 데이터를 요청
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		noticeDao dao = new noticeDao();
		dao.getNoticeDeleteIdx(idx);
		
		

	}

}
