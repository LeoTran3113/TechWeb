package techweb.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import techweb.entity.TechUser;
import techweb.service.TechUserService;


@WebServlet("/techRegister")
public class TechRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public TechRegisterServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");

		TechUser user = new TechUser(0, username, password, email);
		TechUserService userService = new TechUserService();

		try {
			boolean isInsertSuccess = userService.insertTechUser(user);
			if(isInsertSuccess) {
				response.sendRedirect("techRegisterSuccess.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("techRegister.jsp");
				request.setAttribute("errorMessage", "Username or email has been used, please try again !!");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		doGet(request, response);

	}
}