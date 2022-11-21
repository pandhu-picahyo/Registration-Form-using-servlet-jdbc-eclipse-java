package com.info;

import java.io.IOException;  
import java.io.PrintWriter;
  

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/DetailData")  
public class DetailData extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();    
        out.println("<h1>Employees Data</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Emp e=EmpDao.getEmployeeById(id);  
          
        out.print( 
        		"<br><h2>Name       : "+e.getName()+"</h2>" + 
        		"<h2>Email          : "+e.getEmail()+"</h2>" + 
        		"<h2>Address        : "+e.getAddress()+"</h2>" +
        		"<h2>Phone          : "+e.getPhone()+"</h2>" +
        		"<h2>City           : "+e.getCity()+"</h2>" +
        		"<h2>Country        : "+e.getCountry()+"</h2> " +
        		"<h2>Education      : "+e.getEducation()+"</h2>");
        
        out.print( 
        			"<img src=\'ImageData?id="+e.getId()+"' width= '300px' />");
        out.print(
        		 		"<br><br><tr><td><h1><a href='EditData?id="+e.getId()+"'>edit</a>"
        		 		+ "<a></a><a></a><a></a>"      		 		
        		 		+ "<input type=\"submit\" value=\"Download PDF\" name=\"download\" onclick=\"window.print()\""
        		 		+ "<a></a><a></a><a></a>"
        		  		+ "<a href='DeleteData?id="+e.getId()+"'>delete</a></h1></td></tr>");  
        
        }  
            
}  