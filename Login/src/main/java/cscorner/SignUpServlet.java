package cscorner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			PrintWriter out = response.getWriter(); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage","root","lokesh281004");
			String name = request.getParameter("txtName");
			String password = request.getParameter("txtPwd");
			String mail = request.getParameter("mail");
			
			PreparedStatement ps = con.prepareStatement("insert into useraccount values(?,?,?);");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, mail);
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				
				 RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				 rd.forward(request, response);
			
			} else {
				out.print("<font color=red size=30>Insertion failed! ");
				out.println("<a href=siginup.jsp> Try agin</a>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
