package dao.searchCategoryPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;
import utility.Criteria;
import utility.PageDto;

public class SearchSelectedPageService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
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
		
		String country = request.getParameter("country");
		String ingredient = request.getParameter("ingredient");
		String season = request.getParameter("season");
		
		request.setAttribute("listCountry", listCountry);
		request.setAttribute("listIngredient", listIngredient);
		request.setAttribute("listSeason", listSeason);
		
		//OXX
		if(country!=null && ingredient==null && season==null) {
		cri.setCountry(country);
		List<SearchCategoryPageVo> selectedCategory= dao.selectedCategory(country, cri);
		request.setAttribute("selectedCategory", selectedCategory);
		request.setAttribute("country", country);
		
		int total = dao.getFoodCountCountry(country);
		
		PageDto dto = new PageDto(cri, total);
		request.setAttribute("page", dto);
		}
		
		//XOX
		if(country==null && ingredient!=null && season==null) {
		cri.setIngredient(ingredient);
		List<SearchCategoryPageVo> selectedCategory= dao.selectedCategoryIngredient(ingredient, cri);
		request.setAttribute("selectedCategory", selectedCategory);
		request.setAttribute("ingredient", ingredient);
	
		int total = dao.getFoodCountIngredient(ingredient);
		
		PageDto dto = new PageDto(cri, total);
		request.setAttribute("page", dto);
		}
		
		//XXO
		if(country==null && ingredient==null && season!=null) {
		cri.setSeason(season);
		List<SearchCategoryPageVo> selectedCategory= dao.selectedCategorySeason(season, cri);
		request.setAttribute("selectedCategory", selectedCategory);
		request.setAttribute("season", season);
		
		int total = dao.getFoodCountSeason(season);
		
		PageDto dto = new PageDto(cri, total);
		request.setAttribute("page", dto);
		}
		
		//OOX
		if(country!=null && ingredient!=null && season==null) {
		cri.setCountry(country);
		cri.setIngredient(ingredient);
		List<SearchCategoryPageVo> selectedCategory = dao.selectedCategory(country, ingredient, cri);
		request.setAttribute("selectedCategory", selectedCategory);
		request.setAttribute("country", country);
		request.setAttribute("ingredient", ingredient);
		
		int total = dao.getFoodCountCoIn(country, ingredient);
		
		PageDto dto = new PageDto(cri, total);
		request.setAttribute("page", dto);
		
		}
		
		//OXO
		if(country!=null && ingredient==null && season!=null) {
		cri.setCountry(country);
		cri.setSeason(season);			
		List<SearchCategoryPageVo> selectedCategory = dao.selectedCategoryCoSe(country, season, cri);
		request.setAttribute("selectedCategory", selectedCategory);
		request.setAttribute("country", country);
		request.setAttribute("season", season);
		
		int total = dao.getFoodCountCoSe(country, season);
		
		PageDto dto = new PageDto(cri, total);
		request.setAttribute("page", dto);
		}
		
		//XOO
		if(country==null && ingredient!=null && season!=null) {
		cri.setIngredient(ingredient);
		cri.setSeason(season);			
		List<SearchCategoryPageVo> selectedCategory = dao.selectedCategoryInSe(ingredient, season, cri);
		request.setAttribute("selectedCategory", selectedCategory);
		request.setAttribute("ingredient", ingredient);
		request.setAttribute("season", season);
		
		int total = dao.getFoodCountInSe(ingredient, season);
		
		PageDto dto = new PageDto(cri, total);
		request.setAttribute("page", dto);
		}
		
		//OOO
		if(country!=null && ingredient!=null && season!=null) {
		cri.setCountry(country);
		cri.setIngredient(ingredient);
		cri.setSeason(season);
		List<SearchCategoryPageVo> selectedCategory = dao.selectedCategory(country, ingredient, season, cri);
		request.setAttribute("selectedCategory", selectedCategory);
		request.setAttribute("country", country);
		request.setAttribute("ingredient", ingredient);
		request.setAttribute("season", season);
		
		int total = dao.getFoodCountAll(country, ingredient, season);
		
		PageDto dto = new PageDto(cri, total);
		request.setAttribute("page", dto);
		}
		
		//XXX
		if(country==null && ingredient==null && season==null) {
		List<SearchCategoryPageVo> selectedCategory = dao.selectCategoryPage(cri);
		request.setAttribute("selectedCategory", selectedCategory);
		
		int total=dao.getFoodCount();
		
		PageDto dto = new PageDto(cri, total);
		request.setAttribute("page", dto);
		}
	}

}
