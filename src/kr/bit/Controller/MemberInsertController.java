package kr.bit.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ctx = request.getContextPath();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age")); // "40"->40
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		// 파라메터수집(VO)
		// MemberVO vo=new MemberVO(id, pass, name, age, email, phone);
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);

		// System.out.println(vo); // vo.toString()
		// Model과 연동부분
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
		String nextPage = null;
		if (cnt > 0) {
			// 가입성공
			nextPage = "redirect:" + ctx + "/memberList.do";
		} else {
			// 가입실패-> 예외객체를 만들어서 WAS에게 던지자.
			throw new ServletException("not insert");
		}
		return nextPage;
	}

}