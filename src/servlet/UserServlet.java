package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.OrderTableImpl;
import DAO.TradeTableImpl;
import DAO.UserTableImpl;
import businessLogic.OrderProcessesInterfaceImpl;
import pojo.Order;
import pojo.Trade;
import pojo.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub

        HttpSession session = request.getSession();
		String loginId=(String)session.getAttribute("loginId");	
		if(!(loginId != null && !loginId.isEmpty())) {
        	request.setAttribute("errorString", "session expired");
        	//System.out.println("no session 1");
        	
    		RequestDispatcher d=request.getRequestDispatcher("login.jsp");
    		d.forward(request, response);  
    		return;
 
        }
//		System.out.println("\n\nlogin id is "+ loginId);
		if(Objects.equals(loginId, "admin"))
		{
//			System.out.println("entered check\n\n");
			request.setAttribute("errorString", "You're not a registered user. Login Again.");
			session.invalidate();	           
			RequestDispatcher d=request.getRequestDispatcher("login.jsp");
    		d.forward(request, response);  
    		return;
		}
//		System.out.println("didn't enter check\n\n");

        System.out.println("user servlet accessed");
		UserTableImpl a=new UserTableImpl();
		OrderProcessesInterfaceImpl b=new OrderProcessesInterfaceImpl();
		OrderTableImpl i=new OrderTableImpl();
		TradeTableImpl t=new TradeTableImpl();

		System.out.println(loginId);
		List<User>u=a.GetUserByLoginid(loginId);
		User user=u.get(0);
		int number_orders=b.GetStatisticsUser(user.getUserId(),"order");
		int number_trades=b.GetStatisticsUser(user.getUserId(),"trade");
		String position_type=b.GetStatisticsUser(user.getUserId());
		request.setAttribute("statistics_order", number_orders);
		request.setAttribute("statistics_trade", number_trades);
		request.setAttribute("statistics_position", position_type);
		request.setAttribute("name", user.getName());
		int n=5;
		List<Order>list_orders=i.GetOrderByUserId(user.getUserId(),n);
		List<Trade>list_trades=t.GetTradesByUserId(user.getUserId(),n);
	    request.setAttribute("list_orders",list_orders);
		request.setAttribute("list_trades",list_trades);
		RequestDispatcher d=request.getRequestDispatcher("index2_user.jsp");
		d.forward(request, response);  
    }

}
