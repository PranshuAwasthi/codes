package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EmpDao.EmpDao;
import EmpDto.EmpDto;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();  
	        out.println("<a href='Second.html'>Add New Inventory</a>");  
	        out.println("<h1>Inventory  List</h1>");  
	          
	        List<EmpDao> list=EmpDto.getAllEmployees();  
	          
	        out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>SNNo</th><th>DmsNo</th><th>TypeOfPc</th><th>Location</th><th>OsInstalled</th><th>MsOffice</th><th>TypeOfNode</th><th>Ram</th><th>Edit</th><th>Delete</th></tr>");  
	        for(EmpDao e:list){  
	         out.print("<tr><td>"+e.getSNNo()+"</td><td>"+e.getDmsNo()+"</td><td>"+e.getTypeOfPc()+"</td><td>"+e.getLocation()+"</td><td>"+e.getOsInstalled()+"</td><td>"+e.getMsOffice()+"</td><td>"+e.getTypeOfNode()+"</td><td>"+e.getRam()+"</td><td><a href='EditServlet?DmsNo="+e.getDmsNo()+"'>edit</a></td><td><a href='Delete?DmsNo="+e.getDmsNo()+"'>delete</a></td></tr>");  
	        }  
	        out.print("</table>"); 
	       
	          
	        out.close();  
	}

	

}