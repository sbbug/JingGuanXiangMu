package com.link.mysql.test;

import java.sql.Connection;

/*
 * 
 * MySQL数据库连接测试类
 */

public class Test {

	public static void main(String[] args) {
		
		  //定义一个变量
          Connection con = null;
     
          con = GetMysqlCon.getConnection();
          if(con==null){
        	  System.out.println("连接失败");
          }else{
        	  System.out.println("连接成功 con=====>"+con);
          }
          
          GetMysqlCon.closeMysql();
	}

}
