package EmpDto;

import static as.Sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import EmpDao.EmpDao;

public class EmpDto
{
		    public static int save(EmpDao e){   
		         int status=0;   
		         
		         
		         try{   
		              Connection con=getConnection();   
	PreparedStatement ps=con.prepareStatement( "insert into student(SNNo,DmsNo,TypeOfPc,Location,OsInstalled,MsOffice,TypeOfNode,Ram) values (?,?,?,?,?,?,?,?)");  
		            ps.setString(1,e.getSNNo());  
		            ps.setString(2,e.getDmsNo());  
		            ps.setString(3,e.getTypeOfPc());  
		            ps.setString(4,e.getLocation());  
		            ps.setString(5,e.getOsInstalled()); 
		            ps.setString(6,e.getMsOffice());
		            ps.setString(7,e.getTypeOfNode());
		            ps.setString(8,e.getRam()); 
		            status=ps.executeUpdate();  
		              ps.close();
		            con.close();  
		             
		           
		         }catch(Exception ex){ex.printStackTrace();}   
		            
		         return status;   
		     }   
		    public static int update(EmpDao e,String id){   
		         int status=0;   
		         try{   
		             Connection con=getConnection();   
		             PreparedStatement ps=con.prepareStatement(   
		                          "update student set SNNo=?,DmsNo=?,TypeOfPc=?,Location=?,OsInstalled=?,MsOffice=?,TypeOfNode=?,Ram=? where DmsNo=?");   
		              
		                ps.setString(1,e.getSNNo());  
			            ps.setString(2,e.getDmsNo());  
			            ps.setString(3,e.getTypeOfPc());  
			            ps.setString(4,e.getLocation());  
			            ps.setString(5,e.getOsInstalled()); 
			            ps.setString(6,e.getMsOffice());
			            ps.setString(7,e.getTypeOfNode());
			            ps.setString(8,e.getRam());
			            ps.setString(9,id);
			            
		                
		             status=ps.executeUpdate();   
		                ps.close();
		             con.close();   
		         }catch(Exception ex){ex.printStackTrace();}   
		           
	       return status;   
		    }   
		     public static int delete(String DmsNo){   
		        int status=0;   
		         try{   
		             Connection con=getConnection();   
		             PreparedStatement ps=con.prepareStatement("delete from student where DmsNo=?");   
		             ps.setString(1,DmsNo);   
		             status=ps.executeUpdate();   
		             ps.close();  
		             con.close();   
		         }catch(Exception ex){ex.printStackTrace();}   
		           
		         return status;   
		     }   
		     public static EmpDao getEmployeeByDmsNO(String DmsNo){   
		        EmpDao e=new EmpDao();   
		            
		        try{   
		             Connection con=getConnection();   
		             PreparedStatement ps=con.prepareStatement("select * from student where DmsNo=?");   
		             ps.setString(1,DmsNo);   
		             ResultSet rs=ps.executeQuery();   
		             if(rs.next()){  
		            	// e.setId(rs.getInt(1));  
		            	    e.setSNNo(rs.getString(1));  
		            	    e.setDmsNo(rs.getString(2));  
		            	    e.setTypeOfPc(rs.getString(3));  
		            	    e.setLocation(rs.getString(4));  
		            	    e.setOsInstalled(rs.getString(5));
		            	    e.setMsOffice(rs.getString(6));
		            	    e.setTypeOfNode(rs.getString(7));
		            	    e.setRam(rs.getString(8)); 
		             }   
		             con.close();   
		         }catch(Exception ex){ex.printStackTrace();}   
		            
		         return e;   
		     }   
		    public static List<EmpDao> getAllEmployees(){   
		         List<EmpDao> list=new ArrayList<EmpDao>();   
		            
		         try{   
		             Connection con=getConnection();   
		             PreparedStatement ps=con.prepareStatement("select * from student");   
		             ResultSet rs=ps.executeQuery();   
		             while(rs.next()){   
		            	  EmpDao e=new EmpDao();    
		                 e.setSNNo(rs.getString(1));  
		            	    e.setDmsNo(rs.getString(2));  
		            	    e.setTypeOfPc(rs.getString(3));  
		            	    e.setLocation(rs.getString(4));  
		            	    e.setOsInstalled(rs.getString(5));
		            	    e.setMsOffice(rs.getString(6));
		            	    e.setTypeOfNode(rs.getString(7));
		            	    e.setRam(rs.getString(8));  
		                 list.add(e);   
		             }   
		             con.close();   
		         }catch(Exception e){e.printStackTrace();}   
		            
		         return list;   
		     }   
}
