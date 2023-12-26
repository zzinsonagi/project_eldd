package sub4;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Action;

public class Sub4Female5Service implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		RPDAO dao = new RPDAO();
		List<RPVO> list = dao.rankGenderF();
		
		request.setAttribute("list", list);
		
	}

}
