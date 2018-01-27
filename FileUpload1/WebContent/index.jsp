<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>文件上传类</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./Css/bootstrap.css">

</head>
<body>
   <form action="./UploadFile" method = "post" enctype="multipart/form-data">
		 
		  <div class="form-group">
		    <label for="exampleInputFile">File input</label>
		    <input type="file" id="exampleInputFile" name="file">  <!-- 这里需要加name="file" -->
		    <p class="help-block">Example block-level help text here.</p>
		  </div>
  
          <button type="submit" class="btn btn-info">Submit</button>
  </form>
  
</body>
</html>