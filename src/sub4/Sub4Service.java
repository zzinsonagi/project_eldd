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
		List<RPVO> list = dao.randomView();
				
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
		request.setAttribute("list", list); //랜덤 5개 담은 것

	}

}
