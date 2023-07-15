package techweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import techweb.entity.TechAccount;
import techweb.service.TechLoginService;


/**
 * Servlet implementation class TechLoginServlet
 */
@WebServlet("/login")
public class TechLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TechLoginServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try { 
			String username = request.getParameter("user");
			String password = request.getParameter("pass");
			
			TechLoginService techLoginService = new TechLoginService();
			
			TechAccount acc = techLoginService.login(username, password);
			
			if(acc == null) {
				//response.sendRedirect("fail.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("techLogin.jsp");
				request.setAttribute("message","Wrong user or password");
				rd.forward(request, response);
			}else {
				//request.getRequestDispatcher("home.jsp").forward(request, response);
				//response.sendRedirect("home");
				HttpSession session = request.getSession();
				session.setAttribute("acc", acc.getUser_name());
				response.sendRedirect("index.jsp");
			
				
			}
			System.out.println(acc.getId());
			System.out.println(acc.getEmail());

		}catch (Exception e) {}
			
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
