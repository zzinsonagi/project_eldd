package searchCategoryPage;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import utility.Criteria;
import utility.PageDto;

public class SearchCategoryPageService2 implements Action {

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
		
		cri.setPageNum(pageNum);
		cri.setAmount(amount);
		
		SearchCategoryPageDao dao = new SearchCategoryPageDao();
		List<SearchCategoryPageVo> listCountry = dao.getCategoryCountry();
		List<SearchCategoryPageVo> listIngredient = dao.getCategoryIngredient();
		List<SearchCategoryPageVo> listSeason = dao.getCategorySeason();
		List<SearchCategoryPageVo> listFood = dao.selectCategoryPage(cri);
		
		int total=dao.getFoodCount();
		
		PageDto dto = new PageDto(cri, total);
		
		request.setAttribute("listCountry", listCountry);
		request.setAttribute("listIngredient", listIngredient);
		request.setAttribute("listSeason", listSeason);
		request.setAttribute("listFood", listFood);
		request.setAttribute("page", dto);
	}

}
