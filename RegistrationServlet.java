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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author o
 */

public class RegistrationServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        out.print("Working");

      String uname = request.getParameter("name");
      String uemail = request.getParameter("email");
      String upwd = request.getParameter("pass");
      String urepwd = request.getParameter("re_pass");
      String umobile = request.getParameter("contact");
      
//        PrintWriter out=response.getWriter();
//        out.print(uname);
//        out.print(uemail);
//        out.print(upwd);
//        out.print(umobile);

RequestDispatcher dispatcher = null;
     Connection con=null; 
     
     if(uname==null || uname.equals("")){
         request.setAttribute("status","invalidname");
         dispatcher=request.getRequestDispatcher("registration.jsp");
         dispatcher.forward(request, response);
     }
     
      if(uemail==null || uemail.equals("")){
         request.setAttribute("status","invalidemail");
         dispatcher=request.getRequestDispatcher("registration.jsp");
         dispatcher.forward(request, response);
     }
      
       if(upwd==null || upwd.equals("")){
         request.setAttribute("status","invalidpassword");
         dispatcher=request.getRequestDispatcher("registration.jsp");
         dispatcher.forward(request, response);
     }
       else if(!upwd.equals(urepwd)){
           request.setAttribute("status","invalidcomformpassword");
         dispatcher=request.getRequestDispatcher("registration.jsp");
         dispatcher.forward(request, response);
       }
       
        if(umobile==null || umobile.equals("") ){
         request.setAttribute("status","invalidnumber");
         dispatcher=request.getRequestDispatcher("registration.jsp");
         dispatcher.forward(request, response);
     }
        
         if(umobile.length()<10){
         request.setAttribute("status","invalidnumberLength");
         dispatcher=request.getRequestDispatcher("registration.jsp");
         dispatcher.forward(request, response);
     }
     
try{
   Class.forName("com.mysql.jdbc.Driver");
    con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","jitu");
   PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into userloginsys(uname,upwd,uemail,umobile)values(?,?,?,?)");
   pst.setString(1, uname);
   pst.setString(2, upwd);
   pst.setString(3, uemail);
   pst.setString(4, umobile);
   
  int rowCount =  pst.executeUpdate();
  dispatcher = request.getRequestDispatcher("registration.jsp");
  if(rowCount>0){
      request.setAttribute("status","success");
      dispatcher = request.getRequestDispatcher("login.jsp");
  }
  
  else{
      request.setAttribute("status","error");
  
  }
  dispatcher.forward(request, response);
   
}
catch(Exception e){
  e.printStackTrace();
}

        
    }

   

}
