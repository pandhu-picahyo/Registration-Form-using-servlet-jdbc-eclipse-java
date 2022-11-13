package com.info;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;  

@WebServlet("/EditData2")  
public class EditData2 extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        String phone=request.getParameter("phone");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        String education=request.getParameter("education");
   
          
        Emp e=new Emp();  
        e.setId(id);  
        e.setName(name);    
        e.setEmail(email);
        e.setAddress(address);
        e.setPhone(phone);
        e.setCity(city);
        e.setCountry(country);
        e.setEducation(education);
        
          
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewData");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  