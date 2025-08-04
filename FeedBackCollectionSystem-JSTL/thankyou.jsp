<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thank You</title>
</head>
<body>
<h3>Thank You, ${param.username}!</h3>
<p>Your feedback has been received.</p>

<a href="index.jsp">Go back to Feedback</a>
</body>
</html>
<%@ include file="footer.jsp" %>