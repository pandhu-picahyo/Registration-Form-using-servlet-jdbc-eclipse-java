package com.info;

import java.util.*;
import java.util.Date;

import javax.servlet.http.Part;

import java.io.InputStream;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  
  
public class EmpDao {  
  
    private static Part photo;
	public static Connection getConnection(){  
    	
    	// DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// Date date = new Date();
		// String mydate = dateFormat.format(date);
    	
    	
    	
        Connection con=null;  
        try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myjavacode2", "root", "root");  
        }
        catch(Exception e)
        {System.out.println(e);}  
        	return con;  
    }  
     

    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update registration set name=?, email=?, address=?, phone=?, city=?, country=?, education=? where id=?");  
            ps.setString(1, e.getName());  
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getAddress());
            ps.setString(5, e.getPhone());
            ps.setString(6, e.getCity());
            ps.setString(7, e.getCountry());
            ps.setString(8, e.getEducation());
			ps.setInt(10, e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from registration where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from registration where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));
                e.setAddress(rs.getString(4));
                e.setPhone(rs.getString(5));
                e.setCity(rs.getString(6));
                e.setCountry(rs.getString(7));
                e.setEducation(rs.getString(8));
                e.setPhoto(rs.getBlob(9));
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from registration");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));
                e.setAddress(rs.getString(4));
                e.setPhone(rs.getString(5));
                e.setCity(rs.getString(6));
                e.setCountry(rs.getString(7));
                e.setEducation(rs.getString(8));
                e.setPhoto(rs.getBlob(9));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  