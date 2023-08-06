package techweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import techweb.entity.TechProduct;
import techweb.service.TechProductService;

@WebServlet("/techProductDetail")
public class TechProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TechProductDetailServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String productId = request.getParameter("productId");
			TechProductService techProductService = new TechProductService();
			TechProduct product = techProductService.getProductDetails(Integer.parseInt(productId));
			
			RequestDispatcher rd = request.getRequestDispatcher("techProductDetails.jsp");
			
			request.setAttribute("product", product);
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
