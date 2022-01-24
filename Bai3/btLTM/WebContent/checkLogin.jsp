<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%
	String username = request.getParameter("username");
	String pass = request.getParameter("password");
	
	String address = "hehehehe";
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dulieu", "root", "");
	    out.println ( "database successfully opened.");
	    
	    //Statement stmt = con.createStatement();
        // get data from table 'student'
        //ResultSet rs = stmt.executeQuery();
        PreparedStatement stmt = con.prepareStatement("select * from admin where username = ? and password = ? ");
        stmt.setString(1, username);
        stmt.setString(2, pass);
        ResultSet rs = stmt.executeQuery();
        // show data
    	   
	       	if(rs.next() && username.equals(rs.getString(1)) && pass.equals(rs.getString(2))) {
	       		request.setAttribute("address", address);
	       		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
	       		rd.forward(request, response);
	       	}
	       	else {
	       		response.sendRedirect("login.jsp");
	       	}
        
       	stmt.close();
        con.close();
	  }
	  catch(SQLException e) {
	    out.println("SQLException caught: " +e.getMessage());
	  }
	
	
	
	/* if("hehe".equals(username)) {
		request.setAttribute("address", address);
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
	}
	else {
		response.sendRedirect("login.jsp");
	}*/
	
%>
