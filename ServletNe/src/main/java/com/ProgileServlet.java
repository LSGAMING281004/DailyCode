package com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProgileServlet
 */
@WebServlet("/ProgileServlet")
public class ProgileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		String name = "";
		
		Cookie[] cookies = request.getCookies();
		if(cookies == null)
		{
			out.println("<h1>YOu are a new user, kindly login.</h1>");
			request.getRequestDispatcher("login.html");
		} else {
			for(Cookie c: cookies) {
				String tempName = c.getName();
				if(tempName.equals("username")) {
					name = c.getValue();
				}
				out.print("You are the already logedin "+name);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

// Cookie is nothing but small peace of data stored in client browser and send with HTTP request to the server
// Session - session is a object used to store data on the server on the particular user.
// It is used to track user state like login etc,.. and it can be managed HTTP session object.
