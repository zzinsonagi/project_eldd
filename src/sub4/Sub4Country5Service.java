package sub4;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class Sub4Country5Service implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String country = request.getParameter("country");
		
		RPDAO dao = new RPDAO();
		List<RPVO> list = dao.rankCountry(country);
		
		request.setAttribute("list", list);
		
	}

}
