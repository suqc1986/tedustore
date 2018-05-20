<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px">
	<form action="${pageContext.request.contextPath}/test/doUpload.do" method="post" enctype="multipart/form-data">
		<input type="file" name="file" id = "file">
		<br/>
		<input type="submit" value="提交文件">
	</form>
</body>
</html>