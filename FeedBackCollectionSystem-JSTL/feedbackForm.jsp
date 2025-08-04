<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback form</title>
</head>
<body>
<h3>Please provide your feedback</h3>
<form action="feedbackSummary.jsp" method="post">
  Name: <input type="text" name="username" required><br><br>

  Select Facilities You Want to Give Feedback On:<br>
  <input type="checkbox" name="facility" value="Library">Library<br>
  <input type="checkbox" name="facility" value="Lab">Lab<br>
  <input type="checkbox" name="facility" value="Cafeteria">Cafeteria<br><br>

  Comments:<br>
  <textarea name="comments" rows="4" cols="40"></textarea><br><br>

  <input type="submit" value="Submit Feedback">
</form>

</body>
</html>


<%@ include file="footer.jsp" %>