package com.registation;

import java.sql.*;
import javax.servlet.*;

import sql.IBookConstants;

import java.io.*;

public class RemoveBookServlet extends GenericServlet {
	public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String bkid = req.getParameter("barcode");
		try {
			  Class.forName("com.mysql.jdbc.Driver");
  Connection  con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","jitu");
			PreparedStatement ps = con.prepareStatement(
					"delete from " + IBookConstants.TABLE_BOOK + "  where " + IBookConstants.COLUMN_BARCODE + "=?");
			ps.setString(1, bkid);
			int k = ps.executeUpdate();
			if (k == 1) {
				RequestDispatcher rd = req.getRequestDispatcher("removebook.jsp");
				rd.include(req, res);
				pw.println("<div class=\"tab2\">Book Removed Successfully</div>");
//                                req.setAttribute("status","success");
				pw.println("<div class=\"tab2\"><a href=\"removebook.jsp\">Remove more Books</a></div>");

			} else {
				RequestDispatcher rd = req.getRequestDispatcher("removebook.jsp");
				rd.include(req, res);
				pw.println("<div class=\"tab2\">Book Not Available In The Store</div>");
				pw.println("<div class=\"tab2\"><a href=\"removebook.jsp\">Remove more Books</a></div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
