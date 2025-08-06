package com.example.feedback;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/feedback")
public class FeedBackServlet extends HttpServlet {

	
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/feedback_db";
	    private static final String DB_USER = "root";
	    private static final String DB_PASS = "root"; // Your MySQL password

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String name = request.getParameter("studentName");
	        String email = request.getParameter("email");
	        String course = request.getParameter("course");
	        String feedback = request.getParameter("feedback");

	        // Check Cookie for duplicate submission
	        Cookie[] cookies = request.getCookies();
	        boolean alreadySubmitted = false;

	        if (cookies != null) {
	            for (Cookie c : cookies) {
	                if (c.getName().equals("submitted") && c.getValue().equals("yes")) {
	                    alreadySubmitted = true;
	                    break;
	                }
	            }
	        }

	        if (alreadySubmitted) {
	            out.println("<h3>You have already submitted feedback!</h3>");
	        } else {
	            // Display Confirmation
	            out.println("<h2>Thank you for your feedback, " + name + "!</h2>");
	            out.println("<p>Email: " + email + "</p>");
	            out.println("<p>Course: " + course + "</p>");
	            out.println("<p>Your Feedback: " + feedback + "</p>");

	            // Optional DB Storage
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	                String sql = "INSERT INTO feedback (student_name, email, course, feedback) VALUES (?, ?, ?, ?)";
	                PreparedStatement stmt = conn.prepareStatement(sql);
	                stmt.setString(1, name);
	                stmt.setString(2, email);
	                stmt.setString(3, course);
	                stmt.setString(4, feedback);
	                stmt.executeUpdate();
	                stmt.close();
	                conn.close();
	            } catch (Exception e) {
	                out.println("<h3 style='color:red;'>Database Error: " + e.getMessage() + "</h3>");
	            }

	            // Set Cookie to prevent duplicate submission
	            Cookie feedbackCookie = new Cookie("submitted", "yes");
	            feedbackCookie.setMaxAge(60 * 60 * 24); // 1 day
	            response.addCookie(feedbackCookie);
	        }
	    }
}
