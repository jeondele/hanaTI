package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TodoDao;
import model.TodoDto;

/**
 * Servlet implementation class controller
 */
@WebServlet("/cont")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public controller() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = request.getParameter("command");
		if (command.equals("submit")) {
			getSubmit();
		}

	}

	private void getSubmit() {

	}

	public void clientInsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TodoDao dao = new TodoDao();
		String url = "showError.jsp";
		
		try {
			System.out.println("------------");
			dao.addTodo(new TodoDto(Long.valueOf(request.getParameter("id")), request.getParameter("name"), request.getParameter("regdate"),
												Integer.valueOf(request.getParameter("sequence")), request.getParameter("title"), request.getParameter("type")));
												request.setAttribute("name", request.getParameter("name"));
			url = "main.html";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
	}
	
	public void clientUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			System.out.println("------------");
			TodoDao dao = new TodoDao();		
			int count = dao.updateTodo(request.getParameter("type"), Integer.valueOf(request.getParameter("id")));
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
	}

}
