/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registation;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//import sql.IOnlineBookStoreConstants;
//import sql.IBookConstants;
public class AddBookServlet extends GenericServlet {

    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        String barcode = req.getParameter("barcode");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String id = req.getParameter("id");

//        RequestDispatcher dispatcher = null;
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "jitu");

            PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into books(barcode,name,author,price,quantity,id)values(?,?,?,?,?,?)");
            ps.setString(1, barcode);
            ps.setString(2, name);
            ps.setString(3, author);
            ps.setInt(4, price);
            ps.setInt(5, quantity);
            ps.setString(6, id);
            int rowCount = ps.executeUpdate();
            RequestDispatcher dispatcher = req.getRequestDispatcher("AddBook.jsp");

            if (rowCount > 0) {

//                dispatcher = req.getRequestDispatcher("Admin.jsp");
                req.setAttribute("status", "success");
            } else {

                req.setAttribute("status", "error");
                dispatcher = req.getRequestDispatcher("AddBook.jsp");
//                dispatcher.include(req, res);
//                pw.println("<div class=\"tab\">Book is Not Added In The Store</div>");

            }
            dispatcher.forward(req, res);
//            con.close();
        } catch (IOException | ClassNotFoundException | SQLException | ServletException e) {
           
          RequestDispatcher  dispatcher = req.getRequestDispatcher("AddBook.jsp");
          dispatcher.include(req, res);
                pw.println("<div class=\"tab2\">Book is Not Added In The Store Sucessfully "
                        + "Due to some error Add Book Once More</div>");
        }

    }

}
