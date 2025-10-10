package cscorner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			PrintWriter out = response.getWriter(); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage","root","lokesh281004");
			String name = request.getParameter("txtName");
			String password = request.getParameter("txtPwd");
			
			PreparedStatement ps = con.prepareStatement("select uname from useraccount where uname=? and password=?;");
			ps.setString(1, name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Cookie cookie = new Cookie("username", name);
				cookie.setMaxAge(60 * 60 * 24); // 1 day in seconds
				response.addCookie(cookie);

				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else {
				out.print("<font color=red size=30>Login Failed!     ");
				out.println("<a href=login.jsp>Try agin</a>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
