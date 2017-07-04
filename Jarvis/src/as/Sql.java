package as;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Sql {
	public static Connection getConnection() throws ClassNotFoundException 
	{
			    	        Connection conn = null;
			    	        try {
			    	        Class.forName("org.sqlite.JDBC");
			    	            String url = "jdbc:sqlite:C:/Users/desktop/5GDB.db";
			    	            conn = DriverManager.getConnection(url);
			    	            
			    	        System.out.println("Connection to SQLite has been established.");
			    	            
			    	        } catch (SQLException e) {
			    	            System.out.println(e.getMessage());
			    	  
			          
			     }
							return conn;   }
}
	