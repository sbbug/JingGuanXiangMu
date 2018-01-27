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
要在你用的那个tomcat服务器里改
 * 
 * 
 */
/*
 * 
 * 文件保存路径的设置问题
 */

@WebServlet(urlPatterns={"/UploadFile"})
@MultipartConfig  //此处注释是必要的
public class ServiceSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//上传配置
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
		
				 
				              //存储路径
				              String savePath = request.getServletContext().getRealPath("/uploadFile");
				              System.out.println("savePath=====>"+savePath);
				              //获取上传的文件集合
				              Collection<Part> parts = request.getParts();
				              System.out.println("patrs"+parts);
				              //上传单个文件
				              System.out.println("======size"+parts.size());
				             // request.getSession().getServletContext().getRealPath("")
				             
				              if (parts.size()==1) 
				              {
				                   //Servlet3.0将multipart/form-data的POST请求封装成Part，通过Part对上传的文件进行操作。
				                  //Part part = parts[0];//从上传的文件集合中获取Part对象
				                  Part part = request.getPart("file");//通过表单file控件(<input type="file" name="file">)的名字直接获取Part对象
				                  //Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
				                  //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
				                  String header = part.getHeader("content-disposition");
				                  System.out.println("header====>"+header);
				                  //获取文件名
				                  String fileName = getFileName(header);
				                  //把文件写到指定路径
			                      part.write(savePath+File.separator+fileName);
			                      System.out.println("savePath=====>"+savePath);
				              }
				              else if(parts.size()>1)
				              {
				                  //一次性上传多个文件
				                  for (Part part : parts) {//循环处理上传的文件
				                      //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
				                      String header = part.getHeader("content-disposition");
				                      //获取文件名
				                      String fileName = getFileName(header);
			                          //把文件写到指定路径
				                      part.write(savePath+File.separator+fileName);
				                  }
				              }else{
				            	  out.println("No file"); //报错信息写到日志里
				              }
				              out.println("suceess");
				              out.flush();
				             out.close();
		     
		  
		 
       }
	   public String getFileName(String header) {
		          /**
		          * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
		           * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		           * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		           */
		          String[] tempArr1 = header.split(";");
		          /**
		           *火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
		           *IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
		           */
		          String[] tempArr2 = tempArr1[2].split("=");
		          //获取文件名，兼容各种浏览器的写法
		          String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
		          return fileName;
	  }
		      
		 
		
}


