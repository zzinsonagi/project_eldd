package searchPage;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import utility.Criteria;
import utility.PageDto;

public class SearchPageService2 implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		int pageNum = 1;
		int amount = 10;
		
		if(request.getParameter("pageNum")!=null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
			amount=Integer.parseInt(request.getParameter("amount"));
		}
		
		Criteria cri = new Criteria();
		
		cri.setPageNum(pageNum); // 페이지 번호
		cri.setAmount(amount); // 페이지 번호에 맞게 출력할 레코드
		
		String foodname = request.getParameter("foodname");
		
		cri.setFoodname(foodname);
		
		searchPageDao dao = new searchPageDao();
		List<searchPageVo> list = dao.selectSearchPage(foodname, cri);
		int total=dao.getNoticeCountSearched(foodname);
		
		PageDto dto = new PageDto(cri, total);
		
		request.setAttribute("foodList", list);
		request.setAttribute("page", dto);
	}

}
