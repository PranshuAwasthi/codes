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


@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
	      PrintWriter out=response.getWriter();  
	      String id=request.getParameter("id");
	      String SNNo=request.getParameter("SNNo");
	      String DmsNo=request.getParameter("DmsNo");  
		    String TypeOfPc=request.getParameter("TypeOfPc");  
		    String Location=request.getParameter("Location");  
		    String OsInstalled=request.getParameter("OsInstalled");
		    String Msoffice=request.getParameter("Msoffice");
		    String TypeOfNode=request.getParameter("TypeOfNode");
		   String Ram=request.getParameter("Ram");
	        
	      EmpDao e=new EmpDao();  
	      e.setSNNo(SNNo);  
		    e.setDmsNo(DmsNo);  
		    e.setTypeOfPc(TypeOfPc);  
		    e.setLocation(Location);  
		    e.setOsInstalled(OsInstalled);
		    e.setMsOffice(Msoffice);
		    e.setTypeOfNode(TypeOfNode);
		     e.setRam(Ram);
	     
	      int status=EmpDto.update(e,id);  
	      if(status!=0){  
	          response.sendRedirect("ViewServlet");  
	      }else{  
	          out.println("Sorry! unable to update record");  
	      }  
	        
	      out.close();  
		}

	}



