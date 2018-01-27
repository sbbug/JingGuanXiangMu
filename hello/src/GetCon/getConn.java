
package GetCon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class getConn {

   public static Connection con = null;	
	
   public static Connection getConnection(){
	   
	   try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.out.println(e.toString());
		}
	   
	   if(con == null){
		  try{
				con = DriverManager.getConnection(Config.path, Config.username, Config.password);
						
		    }catch(SQLException e){
				System.out.print(e.toString());
		   }
	   }
	   
	   return con;
   }
   
   public static void closeMysql(){
	   try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public static String show(){
	   
	   return "hello";
   }
	

}
