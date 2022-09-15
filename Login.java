/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registation;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author o
 */
public class Login extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,IllegalStateException {
        String uemail = request.getParameter("username");
        String upwd = request.getParameter("password");
        
        HttpSession session= request.getSession();
        RequestDispatcher dispatcher = null;
        
        if(uemail==null || uemail.equals("")){
            request.setAttribute("status","invalidEmail");
            dispatcher=request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);

        }
        
         if(upwd==null || upwd.equals("")){
            request.setAttribute("status","invalidPassword");
            dispatcher=request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        
        try{
        Class.forName("com.mysql.jdbc.Driver");
      Connection con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","jitu");
        PreparedStatement pst;
//      
        pst= (PreparedStatement) con.prepareStatement("select * from userloginsys where uemail = ? and upwd= ?");
        pst.setString(1, uemail);
        pst.setString(2, upwd);
        
        
//        java.sql.PreparedStatement ps = con.prepareStatement("Select * from userloginsys where uemail = jitenmohantyaz@gmai.com" );
        
       ResultSet rs= pst.executeQuery();
       
       if("jitenmohantyaz@gmail.com".equals(uemail) && "456".equals(upwd)){
       response.sendRedirect("Admin.jsp");
       }
       else{
 if(rs.next()){
       session.setAttribute("name", rs.getString("uname"));
       dispatcher =request.getRequestDispatcher("index.jsp");
       
       }else{
       
           request.setAttribute("status","failed");
       dispatcher =request.getRequestDispatcher("login.jsp");
       }
       }
       dispatcher.forward(request, response);
        }
        catch(Exception e){
  e.printStackTrace();
}
        
    }

    

}
