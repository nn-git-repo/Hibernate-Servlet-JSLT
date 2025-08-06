<!DOCTYPE html>
<html>
<head>
    <title>Feedback Form</title>
</head>
<body>
    <h2>Course Feedback Form</h2>
    <form action="feedback" method="post">
        Name: <input type="text" name="studentName" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Course Attended: <input type="text" name="course" required><br><br>
        Feedback: <textarea name="feedback" required></textarea><br><br>
        <input type="submit" value="Submit Feedback">
    </form>
</body>
</html>
