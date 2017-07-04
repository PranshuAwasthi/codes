package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmpDao.EmpDao;
import EmpDto.EmpDto;


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Inventory</h1>");  
        String DmsNo=request.getParameter("DmsNo");  
      
          
        EmpDao e=EmpDto.getEmployeeByDmsNO(DmsNo);  
          
        out.print("<form action='EditServlet2?' method='post'>");
        out.print("<input type=\"hidden\" value=\""+DmsNo+"\" name=\"id\"> ");
        out.print("<table>");  
        out.print("<tr><td>SNNo</td><td><input type='text' name='SNNo' value='"+e.getSNNo()+"'/></td></tr>");  
        out.print("<tr><td>DmsNo:</td><td><input type='text' name='DmsNo' value='"+e.getDmsNo()+"'/></td></tr>");  
        out.print("<tr><td>TypeOfPc:</td><td><input type='text' name='TypeOfPc' value='"+e.getTypeOfPc()+"'/></td></tr>");  
        out.print("<tr><td>Location:</td><td><input type='text' name='Location' value='"+e.getLocation()+"'/></td></tr>");
        out.print("<tr><td>OsInstalled:</td><td><input type='text' name='OsInstalled' value='"+e.getOsInstalled()+"'/></td></tr>");
        out.print("<tr><td>MsOffice:</td><td><input type='text' name='Msoffice' value='"+e.getMsOffice()+"'/></td></tr>");
        out.print("<tr><td>TypeOfNode:</td><td><input type='text' name='TypeOfNode' value='"+e.getTypeOfNode()+"'/></td></tr>");
        out.print("<tr><td>Ram:</td><td><input type='text' name='Ram' value='"+e.getRam()+"'/></td></tr>");
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
 
	
}

	
	