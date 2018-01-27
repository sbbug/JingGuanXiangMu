package com.link.mysql.test;
//导入相关类包
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//MySQL数据库连接类定义
public class GetMysqlCon {

   public static Connection MysqlCon = null;	
	
   public  static Connection getConnection(){
	   
	   try{
		    //加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			//信息报错
			System.out.println(e.toString());
			System.out.println("驱动加载失败");
		}
	   
	   //如果MysqlCon为空，获取一个连接符资源   
	   if(MysqlCon == null){
		  try{
			  
			  MysqlCon = DriverManager.getConnection(MysqlConfig.path, MysqlConfig.username, MysqlConfig.password);
						
		    }catch(SQLException e){
				System.out.print(e.toString());
				System.out.println("MySQL连接符获取失败");
		   }
	   }
	   
	   return MysqlCon;
   }
   
   //MySQL连接资源释放
   public static void closeMysql(){
	   try {
		   
		   if(MysqlCon!=null){
			   MysqlCon.close();
		   }
		   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("MySQL连接资源释放出错");
		   }
   }
   
   public static String show(){
	   
	   return "hello";
   }
	

}
