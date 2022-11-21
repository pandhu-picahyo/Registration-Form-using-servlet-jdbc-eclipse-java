package com.info;

import java.io.IOException;  
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/EditData2")  
public class EditData2 extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
           
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        String education=request.getParameter("education");
   
        try
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjavacode2", "root", "root");
	        PreparedStatement ps = conn.prepareStatement(
	        		"update registration set name=?, email=?, address=?, phone=?, city=?, country=?, education=? where id=?");
        
	        ps.setString(1, name);
	        ps.setString(2, email);
	        ps.setString(3, address);
	        ps.setString(4, phone);
	        ps.setString(5, city);
	        ps.setString(6, country);
	        ps.setString(7, education);
	        ps.setInt(8, id);
	        
	        ps.executeUpdate();
	        
	        ps.close();
	        conn.close();
	          
	        PrintWriter out=response.getWriter();  
	        
	        out.println ("<html><body><b>Data successfully edited and updated" + "</b></body></html>");
	        response.sendRedirect("ViewData");
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
        
        public static Emp getRecordById(int id)
        {
        	Emp f = null;
        	try
        	{
        		Class.forName("com.mysql.cj.jdbc.Driver");  
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjavacode2", "root", "root");
    	        PreparedStatement ps = conn.prepareStatement(
    	        		"select * from registration where id=?");
        	
        	}
        	catch (Exception e)
        	{
        		e.printStackTrace();
        	}
        }
    }  
  
}  