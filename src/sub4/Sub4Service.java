package sub4;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class Sub4Service implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		RPDAO dao = new RPDAO();
		
		//나라별 분류 태그값 받는 용도
		String country = request.getParameter("country-value");
		
		
		//1위만 출력
		RPVO voWishList = dao.rankWishList1();
		RPVO voLike1 = dao.rankLike1();
		RPVO voFemale1 = dao.rankGender1F();
		RPVO voMale1 = dao.rankGender1M();
		
		RPVO voHansik = dao.rankCountryHansik();
		RPVO voJungsik = dao.rankCountryJungsik();
		RPVO voIlsik = dao.rankCountryIlsik();
		RPVO voYangsik = dao.rankCountryYangsik();
		RPVO voAsiansik = dao.rankCountryAsiansik();
		RPVO voGita = dao.rankCountryGita();
		
		//여러개씩 출력
		List<RPVO> listWishList = dao.rankWishList();
		List<RPVO> listLike = dao.rankLike();
		List<RPVO> listFemale = dao.rankGenderF();
		List<RPVO> listMale = dao.rankGenderM();

		List<RPVO> listHansik = dao.rankCountry(country);
		List<RPVO> listJungsik = dao.rankCountry(country);
		List<RPVO> listIlsik = dao.rankCountry(country);
		List<RPVO> listYangsik = dao.rankCountry(country);
		List<RPVO> listAsiansik = dao.rankCountry(country);
		List<RPVO> listGita = dao.rankCountry(country);
		
		List<RPVO> listRandom = dao.randomView();
		
		
		//1위만 출력
		request.setAttribute("voWishList1", voWishList); //위시 1위
		request.setAttribute("voLike1", voLike1); //좋아요 1위
		request.setAttribute("voFemale1", voFemale1); //여성 1위
		request.setAttribute("voMale1", voMale1); //남성 1위
		request.setAttribute("voHansik", voHansik); //한식 1위
		request.setAttribute("voJungsik", voJungsik); //중식 1위
		request.setAttribute("voIlsik", voIlsik); //일식 1위
		request.setAttribute("voYangsik", voYangsik); //양식 1위
		request.setAttribute("voAsiansik", voAsiansik); //아시안식 1위
		request.setAttribute("voGita", voGita); //기타 1위

		//카테고리별 5위까지 출력용
		request.setAttribute("listWishList", listWishList);
		request.setAttribute("listLike", listLike);
		request.setAttribute("listFemale", listFemale);
		request.setAttribute("listMale", listMale);
		request.setAttribute("listHansik", listHansik);
		request.setAttribute("listJungsik", listJungsik);
		request.setAttribute("listIlsik", listIlsik);
		request.setAttribute("listYangsik", listYangsik);
		request.setAttribute("listAsiansik", listAsiansik);
		request.setAttribute("listGita", listGita);
		
		//맨 밑 랜덤 출력용(5개)
		request.setAttribute("list", listRandom);

	}

}
