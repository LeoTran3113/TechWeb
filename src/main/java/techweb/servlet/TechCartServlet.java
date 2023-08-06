package techweb.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TechDTO.TechCartSession;
import techweb.entity.TechOrderItem;
import techweb.entity.TechProduct;
import techweb.entity.TechUser;
import techweb.service.TechOrderService;
import techweb.service.TechProductService;

@WebServlet("/techCart")
public class TechCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String REQUEST_FROM_REMOVE_ITEM_FROM_CART = "REMOVE";
	private final String REQUEST_FROM_CHECK_OUT_CART = "CHECKOUT";

	public TechCartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String command = request.getParameter("command");
			String productId = request.getParameter("productId");
			// if(command != null) {
			switch (command) {
			case REQUEST_FROM_REMOVE_ITEM_FROM_CART: {
				removeFromCart(productId, request, response);
				return;
			}
			case REQUEST_FROM_CHECK_OUT_CART: {
				checkout(productId, request, response);
				return;
			}

			default:
				addToCart(productId, request, response);
			}
			// }

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void addToCart(String productId, HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, SQLException, IOException {
		TechProductService productService = new TechProductService();
		TechProduct product = productService.getProductDetails(Integer.parseInt(productId));

		HttpSession session = request.getSession();
		TechCartSession cart = (TechCartSession) session.getAttribute("cart");

		if (cart == null) {
			cart = new TechCartSession();

		}
		boolean isAddedSuccess = cart.getProducts().add(product);
		if (isAddedSuccess) {
			cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
		}

		session.setAttribute("cart", cart);
		response.sendRedirect("home");

	}

	public void removeFromCart(String productId, HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, SQLException, IOException {
		TechProductService productService = new TechProductService();
		TechProduct product = productService.getProductDetails(Integer.parseInt(productId));
		HttpSession session = request.getSession();
		TechCartSession cart = (TechCartSession) session.getAttribute("cart");

		cart.getProducts().remove(product);
		cart.setTotalPrice(cart.getTotalPrice() - product.getPrice());
		session.setAttribute("cart", cart);
		response.sendRedirect("techViewCart.jsp");
	}

	public void checkout(String productId, HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, SQLException, IOException {
		HttpSession session = request.getSession();
		TechCartSession cart = (TechCartSession) session.getAttribute("cart");
		TechUser user = (TechUser) session.getAttribute("user");
		cart.setUserId(user.getId());

		TechOrderService orderService = new TechOrderService();
		orderService.insertOrderWithItems(cart);
		request.getSession().removeAttribute("cart");
		response.sendRedirect("home");

		List<TechOrderItem> items = new ArrayList<TechOrderItem>();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
