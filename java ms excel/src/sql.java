import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sql {
	  
    public static Connection getConnection() throws ClassNotFoundException,SQLException
    {  
  	    
	        Connection con=null;  
	        try{
	        	Class.forName("com.mysql.jdbc.Driver");
	    		String url ="jdbc:mysql://localhost:3306/tanu";
	    String userid="root";
	    String Password="tanu";
	    //Step 2 Create connection db 
	    Connection connection=DriverManager.getConnection(url,userid,Password);
	    	if(connection!=null){
	    		System.out.println("connection created......");
	    	connection.close();
	    	}
	    	
	          }
	        catch(Exception e){System.out.println(e);}  
	return con;
    }
	    public static void main(String [] argus) throws ClassNotFoundException, SQLException
    {
    	getConnection();
    	
    }
    
}
