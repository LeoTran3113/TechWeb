package techweb.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TechDTO.TechCartSession;

/**
 * Servlet implementation class TechQuantityServlet
 */
@WebServlet("/techQuantity")
public class TechQuantityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TechQuantityServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			int productId = Integer.parseInt(request.getParameter("productId"));

			@SuppressWarnings("unchecked")
			ArrayList<TechCartSession> cart = (ArrayList<TechCartSession>) request.getSession().getAttribute("cart");

			if (action != null && productId >= 1) {
				if (action.equals("inc")) {
					for (TechCartSession c : cart) {
						if (c.getProducts().equals(productId)) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							response.sendRedirect("techViewCart.jsp");
						}
					}
				}
				if (action.equals("dec")) {
					for (TechCartSession c : cart) {
						if (c.getProducts().equals(productId) && c.getQuantity() > 1) {
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
							break;
						}
					}

					response.sendRedirect("techViewCart.jsp");
				}
			} else {
				response.sendRedirect("techViewCart.jsp");

			}
		} catch (Exception e) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
