package com.link.mysql.test;

import java.sql.Connection;

/*
 * 
 * MySQL���ݿ����Ӳ�����
 */

public class Test {

	public static void main(String[] args) {
		
		  //����һ������
          Connection con = null;
     
          con = GetMysqlCon.getConnection();
          if(con==null){
        	  System.out.println("����ʧ��");
          }else{
        	  System.out.println("���ӳɹ� con=====>"+con);
          }
          
          GetMysqlCon.closeMysql();
	}

}
