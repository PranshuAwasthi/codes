package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import EmpDao.EmpDao;
import EmpDto.EmpDto;



@WebServlet("/SaveServlet1")
public class SaveServlet1 extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  response.setContentType("text/html");  
		   PrintWriter out=response.getWriter();  
		        String SNNo=request.getParameter("SNNo");
		     //   String sid=request.getParameter("SNNo");  
		       // int SNNo=Integer.parseInt(sid); 
		     String DmsNo=request.getParameter("DmsNo");  
		    String TypeOfPc=request.getParameter("TypeOfPc");  
		    String Location=request.getParameter("Location");  
		    String OsInstalled=request.getParameter("OsInstalled");
		    String Msoffice=request.getParameter("MsOffice");
		    String TypeOfNode=request.getParameter("TypeofNode");
		   String Ram=request.getParameter("Ram");
		   // String pid=request.getParameter("Ram");  
		    //int Ram=Integer.parseInt(pid); 
		    

		   
		    EmpDao e=new EmpDao();  
		    e.setSNNo(SNNo);  
		    e.setDmsNo(DmsNo);  
		    e.setTypeOfPc(TypeOfPc);  
		    e.setLocation(Location);  
		    e.setOsInstalled(OsInstalled);
		    e.setMsOffice(Msoffice);
		    e.setTypeOfNode(TypeOfNode);
		     e.setRam(Ram);
         int status=EmpDto.save(e);   
         if(status!=0){   
             out.print("<p>Record saved successfully!</p>");   
             request.getRequestDispatcher("Login.html").include(request, response);   
         }else{   
             out.println("Sorry! unable to save record");   
         }   
         HttpSession session = request.getSession();
	        session.setMaxInactiveInterval(5);
	        //request.getRequestDispatcher(".html").include(request, response);
         out.close();   
     }   
  
 


	}


