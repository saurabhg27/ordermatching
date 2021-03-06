package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.TradeTableImpl;
import DAO.UserTableImpl;
import pojo.Order;
import pojo.Trade;
import pojo.User;

/**
 * Servlet implementation class OpenUserTradesServlet
 */
@WebServlet("/usertrades")
public class OpenUserTradesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenUserTradesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("user trades servlet");
		HttpSession session=request.getSession();
		String loginId=(String)session.getAttribute("loginId");
		UserTableImpl u=new UserTableImpl();
		List<User>us=u.GetUserByLoginid(loginId);
		User user=us.get(0);
	    TradeTableImpl o=new TradeTableImpl();
	    List<Trade>trades= o.GetTradesByUserId(user.getUserId(),100);
	    request.setAttribute("allTrades", trades);
	    request.setAttribute("name", user.getName());
        RequestDispatcher dispatcher= request.getRequestDispatcher("tradehistory.jsp");
        dispatcher.forward(request, response);
	}

}
