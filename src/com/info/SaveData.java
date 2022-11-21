package com.info;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;

import javax.servlet.annotation.MultipartConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;  

@WebServlet("/SaveData")
@MultipartConfig(maxFileSize = 16177216) 
public class SaveData extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
    	
    	
		
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        String education=request.getParameter("education");
        Part filepart=request.getPart("photo"); 
          
        Emp e=new Emp();  
        e.setName(name);
        e.setEmail(email);
        e.setAddress(address);
        e.setPhone(phone);
        e.setCity(city);
        e.setCountry(country);
        e.setEducation(education);
        
     
        Connection con=null;  
        try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjavacode2", "root", "root");  
     
                     
                    PreparedStatement ps=con.prepareStatement(  
                                 "insert into registration" +
                    			 "(name, email, address, phone, city, country, education, photo, date)" +
                                 "values(?, ?, ?, ?, ?, ?, ?, ?, ?)");  
                    
                    Date date = new Date();
                	java.sql.Date sqldate = new java.sql.Date(date.getTime());
                	
                	
                    ps.setString(1, e.getName());  
                    ps.setString(2, e.getEmail());
                    ps.setString(3, e.getAddress());
                    ps.setString(4, e.getPhone());
                    ps.setString(5, e.getCity());
                    ps.setString(6, e.getCountry());
                    ps.setString(7, e.getEducation());
                    
        			InputStream is = filepart.getInputStream();
        			ps.setBlob(8, is);
                    ps.setDate(9, sqldate);
                    
                      
                   int status=ps.executeUpdate();  
                   if(status>0){  
                       out.print("<p>Record saved successfully!</p>");  
                       request.getRequestDispatcher("newuser.html").include(request, response);  
                   }else{  
                       out.println("Sorry! unable to save record");  
                   }   out.close();
                   
                    con.close();  
                }catch(Exception ex){ex.printStackTrace();}  

       
    }  
  
}  