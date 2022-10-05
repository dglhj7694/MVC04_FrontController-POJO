package kr.bit.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.Controller.Controller;
import kr.bit.Controller.MemberContentController;
import kr.bit.Controller.MemberDeleteController;
import kr.bit.Controller.MemberInsertController;
import kr.bit.Controller.MemberListController;
import kr.bit.Controller.MemberRegisterController;
import kr.bit.Controller.MemberUpdateController;
import kr.bit.model.MemberDAO;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = url.substring(ctx.length());
		Controller controller = null;
		String nextPage = null;
		//핸들러 매핑 --HandlerMapping
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(request, response);
		
		//forward, redirect
		if (nextPage!=null) {
			if (nextPage.indexOf("redirect:")!=-1) {
				response.sendRedirect(nextPage.split(":")[1]); //redirect
			}else {
				nextPage = ViewResolver.makeView(nextPage);
				RequestDispatcher rd = request.getRequestDispatcher(nextPage);
				rd.forward(request, response); //forward
			}
		}
	}

}
