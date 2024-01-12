package member;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.Action;

public class EmailCheckService implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String email = request.getParameter("email");

		String auth = new MemberDAO().emailCheck(email, request, response);
		
		HttpSession authKey = request.getSession(); //세션객체 생성
		authKey.setAttribute("authKey", auth);
		

		//---------------------------------------------------메일 보내기 끝
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("msg", "메일전송 성공");
		map.put("check", "ok");
		
		Gson gson = new Gson();
		
		String aaa2 =  gson.toJson(map); //map 객체를 json 형식으로 변환
		System.out.println(aaa2.toString());
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-json, charset=utf-8");
		
		PrintWriter out2 = null;
		try {
			out2 = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out2.write(aaa2.toString()); //문자열로 변환하여 클라이언트로 리턴한다
		
		
	}

}
