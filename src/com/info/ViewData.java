package com.info;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/ViewData")  
public class ViewData extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        String n = request.getParameter("name");  
        out.print("Welcome "+n);    
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print(
        		"<tr><th>Id</th> "+ 
        		"<th>Name</th>" + 
        		"<th>Date</th>" + 
        		"<th>City</th>" +
        		"<th>Status</th>" +
        		"<th>Edit</th>" +
        		"<th>Delete</th></tr>");
        
        for(Emp e:list){  
         out.print(
        		 	"<tr><td>"+e.getId()+"</td>"
        		 		+ "<td>"+e.getName()+"</td>"
        		  		+ "<td>"+e.getDate()+"</td>"
        		  		+ "<td>"+e.getCity()+"</td>"
        		  		+ "<td><a href='DetailData?id="+e.getId()+"'>status</a></td>"
        		  		+ "<td><a href='EditData?id="+e.getId()+"'>edit</a></td>"
        		  		+ "<td><a href='DeleteData?id="+e.getId()+"'>delete</a></td></tr>");  
        
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  