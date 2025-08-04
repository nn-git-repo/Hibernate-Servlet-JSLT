<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FeedBack Summary</title>
</head>
<body>

<h3>Feedback Summary for ${param.username}</h3>

<c:if test="${empty param.facility}">
  <p style="color:red;">No feedback submitted!</p>
</c:if>

<c:if test="${not empty param.facility}">
  <p>Facilities Feedback:</p>
  <ul>
    <c:forEach var="item" items="${paramValues.facility}">
      <li>${item}</li>
    </c:forEach>
  </ul>
</c:if>

<p><strong>Comments:</strong> ${param.comments}</p>
<a href="thankyou.jsp?username=${param.username}">Finish</a>

</body>
</html>

<%@ include file="footer.jsp" %>