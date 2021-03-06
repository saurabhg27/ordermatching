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

import DAO.UserTableImpl;
import pojo.User;

/**
 * Servlet implementation class OpenProfileServlet
 */
@WebServlet("/openservlet")
public class OpenProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OpenProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String loginId=(String)session.getAttribute("loginId");
		UserTableImpl u=new UserTableImpl();
		List<User>us=u.GetUserByLoginid(loginId);
		User user=us.get(0);
		request.setAttribute("name", user.getName());
		request.setAttribute("user", user);
        RequestDispatcher dispatcher= request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);
	}

}
