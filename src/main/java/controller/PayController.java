package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdersDAO;
import model.Cart;

@WebServlet(name = "PayController", value = "/PayController")
public class PayController extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            HttpSession session = request.getSession(true);
            if (session.getAttribute("cart") == null) {
                session.setAttribute("cart", new Cart());
            }
            OrdersDAO dao = new OrdersDAO();
            Cart c = (Cart) session.getAttribute("cart");
            String email = request.getParameter("email");
            String discount = request.getParameter("discount");
            String address = request.getParameter("address");
            dao.insertOrder(email, address, discount, c);
            session.removeAttribute("cart");
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            response.getWriter().println(e);
            e.printStackTrace();
        }
    }
	
}
