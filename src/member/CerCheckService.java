package member;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Action;

public class CerCheckService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String certinumber = request.getParameter("certinumber");
		String authKey = (String) request.getSession().getAttribute("authKey");
		
		Map<String, String> map = new HashMap<String, String>();
		Gson gson = new Gson();
		
		if(certinumber.equals(authKey)) {
			map.put("msg", "인증번호가 일치합니다.");
			map.put("check", "ok");
		} else {
			map.put("msg", "인증번호가 일치하지 않습니다.");
			map.put("check", "not ok");
		}
		
		request.getSession().removeAttribute("authKey"); //세션 다시 지우기 위함
		
		String authjson = gson.toJson(map);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json, charset=utf-8");
		try {
			response.getWriter().write(authjson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
