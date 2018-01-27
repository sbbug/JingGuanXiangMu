package service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/*
 * I solved the problem. I edit the file context.xml (tomcat->conf).
 You need to edit it, putting the attribute allowCasualMultipartParsing="true" in the tag <Context>, 
and then you have:<Context  allowCasualMultipartParsing="true">. 
Restart the server and it works.
Ҫ�����õ��Ǹ�tomcat���������
 * 
 * 
 */
/*
 * 
 * �ļ�����·������������
 */

@WebServlet(urlPatterns={"/UploadFile"})
@MultipartConfig  //�˴�ע���Ǳ�Ҫ��
public class ServiceSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//�ϴ�����
	private static final String UPLOAD_DIRECTORY = "upload";
	private static final int MEMORY_THRESHOLD = 1024*1024*3;
	private static final int MAX_FILE_SIZE = 1024*1024*40;
	private static final int MAX_REQUEST_SIZE = 1024*1024*50;
	
       
    public ServiceSerlvet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    ServletOutputStream out = response.getOutputStream();
		out.print("Hello1");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		         
		         request.setCharacterEncoding("utf-8");
				 ServletOutputStream out = response.getOutputStream();
				 out.print("hello aaaaaaa");
	   		     System.out.println("hello");
		
				 
				              //�洢·��
				              String savePath = request.getServletContext().getRealPath("/uploadFile");
				              System.out.println("savePath=====>"+savePath);
				              //��ȡ�ϴ����ļ�����
				              Collection<Part> parts = request.getParts();
				              System.out.println("patrs"+parts);
				              //�ϴ������ļ�
				              System.out.println("======size"+parts.size());
				             // request.getSession().getServletContext().getRealPath("")
				             
				              if (parts.size()==1) 
				              {
				                   //Servlet3.0��multipart/form-data��POST�����װ��Part��ͨ��Part���ϴ����ļ����в�����
				                  //Part part = parts[0];//���ϴ����ļ������л�ȡPart����
				                  Part part = request.getPart("file");//ͨ����file�ؼ�(<input type="file" name="file">)������ֱ�ӻ�ȡPart����
				                  //Servlet3û���ṩֱ�ӻ�ȡ�ļ����ķ���,��Ҫ������ͷ�н�������
				                  //��ȡ����ͷ������ͷ�ĸ�ʽ��form-data; name="file"; filename="snmp4j--api.zip"
				                  String header = part.getHeader("content-disposition");
				                  System.out.println("header====>"+header);
				                  //��ȡ�ļ���
				                  String fileName = getFileName(header);
				                  //���ļ�д��ָ��·��
			                      part.write(savePath+File.separator+fileName);
			                      System.out.println("savePath=====>"+savePath);
				              }
				              else if(parts.size()>1)
				              {
				                  //һ�����ϴ�����ļ�
				                  for (Part part : parts) {//ѭ�������ϴ����ļ�
				                      //��ȡ����ͷ������ͷ�ĸ�ʽ��form-data; name="file"; filename="snmp4j--api.zip"
				                      String header = part.getHeader("content-disposition");
				                      //��ȡ�ļ���
				                      String fileName = getFileName(header);
			                          //���ļ�д��ָ��·��
				                      part.write(savePath+File.separator+fileName);
				                  }
				              }else{
				            	  out.println("No file"); //������Ϣд����־��
				              }
				              out.println("suceess");
				              out.flush();
				             out.close();
		     
		  
		 
       }
	   public String getFileName(String header) {
		          /**
		          * String[] tempArr1 = header.split(";");����ִ����֮���ڲ�ͬ��������£�tempArr1���������������������
		           * �������google������£�tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		           * IE������£�tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		           */
		          String[] tempArr1 = header.split(";");
		          /**
		           *�������google������£�tempArr2={filename,"snmp4j--api.zip"}
		           *IE������£�tempArr2={filename,"E:\snmp4j--api.zip"}
		           */
		          String[] tempArr2 = tempArr1[2].split("=");
		          //��ȡ�ļ��������ݸ����������д��
		          String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
		          return fileName;
	  }
		      
		 
		
}


