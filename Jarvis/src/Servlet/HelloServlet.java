package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out=response.getWriter();  
	    String name=request.getParameter("name");  
	    String password=request.getParameter("password");  
	      
	    if(name.equals(password)){  
	    out.print("Welcome, "+name);  
	   HttpSession session=request.getSession();  
	    session.setAttribute("name",name);  
	    request.getRequestDispatcher("Login.html").include(request, response);  
	    }  
	    else{  
	        out.print("Sorry, username or password error!");  
	        request.getRequestDispatcher("Second.html").include(request, response);  
	    }  
	    out.close();  
	}  

		}


	
