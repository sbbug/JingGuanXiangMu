package GetCon;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Connection con = null;
     
          con = getConn.getConnection();
          if(con==null){
        	  System.out.println("failed");
          }else{
        	  System.out.println("success  "+con);
          }
          
          getConn.closeMysql();
	}

}
