package EmpDao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import EmpDto.EmpDto;

public class EmpDao {
	
		  
	    public static Connection getConnection() throws ClassNotFoundException,SQLException
	    {  
	       
	    Connection con=null;  
	   
	        try{
	        	
	            Class.forName("com.mysql.jdbc.Driver");
	            con=DriverManager.getConnection(  
	            		"jdbc:mysql://localhost:3306/tanu","root","tanu");  
	    //Step 2 Create connection db 
	  //   con=DriverManager.getConnection(url,userid,Password);
	  //  if(con!=null){
	    //		System.out.println("connection created......");
	    	//con.close();
	    	
	    	
	    
	        }
	        catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(EmpDto e){  
	        int status = 0;  
	        PreparedStatement ps=null;
	        Connection con=null;
	        try{  
	           con=EmpDao.getConnection();  
	             ps=con.prepareStatement(  
	                         "insert into student(SNNo,DmsNo,TypeOfPc,Location,OsInstalled,MsOffice,TypeOfNode,Ram) values (?,?,?,?,?,?,?,?,?)");  
	            ps.setString(1,e.getSNNo());  
	            ps.setString(2,e.getDmsNo());  
	         ps.setString(3,e.getTypeOfPc());  
	            ps.setString(4,e.getLocation());  
	            ps.setString(5,e.getOsInstalled()); 
	            ps.setString(6,e.getMsOffice());
	            ps.setString(7,e.getTypeOfNode());
	            ps.setString(8,e.getRam()); 
	         status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	       return status;  
	    }  
	    public static int update(EmpDto e){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("update user905 set name=?,password=?,email=?,country=? where id=?");  
	            		   ps.setString(1,e.getSNNo());  
	       	            ps.setString(2,e.getDmsNo());  
	       	         ps.setString(3,e.getTypeOfPc());  
	       	            ps.setString(4,e.getLocation());  
	       	            ps.setString(5,e.getOsInstalled()); 
	       	            ps.setString(6,e.getMsOffice());
	       	            ps.setString(7,e.getTypeOfNode());
	       	            ps.setString(8,e.getRam());
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(String Name){  
	        int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from Emp where name=?");  
	            ps.setString(1,Name);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static EmpDto getEmployeeByDmsNo(String DmsNo){  
	        EmpDto e=new EmpDto();  
	          
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from student");  
	            ps.setString(2,DmsNo);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	             //   e.setId(rs.getInt(1));  
	                e.setName(rs.getString(1));  
	                e.setPassword(rs.getString(2));  
	                e.setEmail(rs.getString(3));  
	                e.setCountry(rs.getString(4));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<EmpDto> getAllEmployees(){  
	        List<EmpDto> list=new ArrayList<EmpDto>();  
	          
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from student");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                EmpDto e=new EmpDto();  
	               // e.setId(rs.getInt(1));  
	                e.setName(rs.getString(1));  
	                e.setPassword(rs.getString(2));  
	                e.setEmail(rs.getString(3));  
	                e.setCountry(rs.getString(4));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }
	
	}  





