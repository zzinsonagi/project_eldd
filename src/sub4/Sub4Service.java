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
		
		String country = request.getParameter("country");
		
		RPDAO dao = new RPDAO();
		
		RPVO voLike1 = dao.rankLike1();
		RPVO voCountry1 = dao.rankCountry1(country);
		RPVO voFemale1 = dao.rankGender1F();
		RPVO voMale1 = dao.rankGender1M();
		List<RPVO> list = dao.randomView();
		
		request.setAttribute("voLike1", voLike1);
		request.setAttribute("voCountry1", voCountry1);
		request.setAttribute("voFemale1", voFemale1);
		request.setAttribute("voMale1", voMale1);
		request.setAttribute("list", list);

	}

}
