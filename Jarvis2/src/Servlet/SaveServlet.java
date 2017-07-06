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

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");  
    PrintWriter out=response.getWriter();  
        //String SNNo=request.getParameter("SNNo");
      //  String sid=request.getParameter("SNNo");  
    String SNNo=request.getParameter("SNNo");
    String DmsNo=request.getParameter("DmsNo");  
    String TypeOfPc=request.getParameter("TypeOfPc");  
    String Location=request.getParameter("Location");  
    String OsInstalled=request.getParameter("OsInstalled");
    String Msoffice=request.getParameter("Msoffice");
    String TypeOfNode=request.getParameter("TypeofNode");
    String Ram=request.getParameter("Ram");
//    String pid=request.getParameter("Ram");  
 //   int Ram=Integer.parseInt(pid); 
   //out.print("\n\nSNNo"+SNNo+"\n\nDmsNo"+DmsNo+"TypeOfPc=="+TypeOfPc+"Location"+Location);
    EmpDto e=new EmpDto();  
   e.setSNNo(SNNo);  
    e.setDmsNo(DmsNo);  
  e.setTypeOfPc(TypeOfPc);  
    e.setLocation(Location);  
    e.setOsInstalled(OsInstalled);
    e.setMsOffice(Msoffice);
    e.setTypeOfNode(TypeOfNode);
     e.setRam(Ram);
    int status =EmpDao.save(e);  
   if(status>0){  
        out.print("<p>Record saved successfully!</p>");  
        request.getRequestDispatcher("Login.html").include(request, response);  
    }else{  
        out.println("Sorry! unable to save record");  
    }  
      
    out.close();  
}  
}

