package com.link.mysql.test;
//����������
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//MySQL���ݿ������ඨ��
public class GetMysqlCon {

   public static Connection MysqlCon = null;	
	
   public  static Connection getConnection(){
	   
	   try{
		    //��������
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			//��Ϣ����
			System.out.println(e.toString());
			System.out.println("��������ʧ��");
		}
	   
	   //���MysqlConΪ�գ���ȡһ�����ӷ���Դ   
	   if(MysqlCon == null){
		  try{
			  
			  MysqlCon = DriverManager.getConnection(MysqlConfig.path, MysqlConfig.username, MysqlConfig.password);
						
		    }catch(SQLException e){
				System.out.print(e.toString());
				System.out.println("MySQL���ӷ���ȡʧ��");
		   }
	   }
	   
	   return MysqlCon;
   }
   
   //MySQL������Դ�ͷ�
   public static void closeMysql(){
	   try {
		   
		   if(MysqlCon!=null){
			   MysqlCon.close();
		   }
		   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("MySQL������Դ�ͷų���");
		   }
   }
   
   public static String show(){
	   
	   return "hello";
   }
	

}
