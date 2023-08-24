package techweb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import techweb.entity.TechCategory;
import techweb.entity.TechProduct;
import techweb.service.TechCategoryService;
import techweb.service.TechProductService;

@WebServlet("/home")
public class TechHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TechHomeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int currentPage = 1;
			if (request.getParameter("page") != null) {
				currentPage = Integer.parseInt(request.getParameter("page"));
			}

			TechCategoryService categoryService = new TechCategoryService();
			List<TechCategory> categoryList = categoryService.getAllCategories();

			TechProductService productService = new TechProductService();
			List<TechProduct> productList = productService.getAllProducts();

			String categoryId = request.getParameter("categoryId");
			String productName = request.getParameter("productName");

			if (categoryId != null) {
				productList = productService.getProductsByCategoryId(Integer.parseInt(categoryId));

			} else if (productName != null) {
				productList = productService.getProductsByName(productName);
			} else {
				productList = productService.getProductByPage(currentPage);
			}

			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("productList", productList);
			request.setAttribute("productName", productName);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("categoryId", categoryId);
			request.setAttribute("totalPage", productService.getTotalPage());

			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
