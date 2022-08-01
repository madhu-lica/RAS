import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class UserAuthenticate extends HttpServlet{
		// JDBC driver name and database URL
      static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
      static final String DB_URL="jdbc:mysql://localhost:3306/ResourceAllocationSystem";

      //  Database credentials
      static final String USER = "root";
      static final String PASS = "Ssn2001*";
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
 
		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String title = "Check Credentials";
		String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
		out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title>\n"+
         "<link rel = \"stylesheet\" href = \"../css/cred.css\" type = \"text/css\">\n"+
         "<link rel = \"stylesheet\" href = \"../css/index.css\" type = \"text/css\">\n"+"</head>\n");

        //getting input from the login form
        String username = request.getParameter("username"); 
        String password = request.getParameter("password");
        String designation = request.getParameter("designation");

		try {

            // Register JDBC driver
			Class.forName(JDBC_DRIVER);
			//Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);


			if(username.equals("admin") && password.equals("admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("mainpageadmin.html");
				rd.forward(request, response);
                //////////////////////changes needed.
			}
			else if(designation.equals("faculty")) //FACULTY
            {
				// Execute SQL query
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM faculty";
				ResultSet rs = stmt.executeQuery(sql);

				// Extract data from result set
				int flag=0;
				while(rs.next())
                {
					//Retrieve by column name
					String uname  = rs.getString("username");
					String pass = rs.getString("password");
					if(uname.equals(username) && pass.equals(password)) 
                    {
					    RequestDispatcher rd = request.getRequestDispatcher("mainpagefaculty.html");
					    // forwarding the request to Welcome.java
					    rd.forward(request, response);
					    flag=1; 
					}
				}
				if(flag == 0) {
					out.println("<h3 style=\"text-align:center\">Invalid Credentials!</h3>");
					RequestDispatcher rd = request.getRequestDispatcher("login.html");
					rd.include(request, response);
				}
				out.println("</body></html>");

				// Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
			}//end of else if 1

            else if(designation.equals("student"))  //STUDENT
            {
                // Execute SQL query
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM student";
				ResultSet rs = stmt.executeQuery(sql);

				// Extract data from result set
				int flag=0;
				while(rs.next()){
					//Retrieve by column name
					String uname  = rs.getString("username");
					String pass = rs.getString("password");
					if(uname.equals(username) && pass.equals(password)) 
                    {
					    RequestDispatcher rd = request.getRequestDispatcher("mainpagestudents.html");
    					// forwarding the request to Welcome.java
    					rd.forward(request, response);
    					flag=1;
					}
				}
				if(flag == 0) {
					out.println("<h3 style=\"text-align:center\">Invalid Credentials!</h3>");
					RequestDispatcher rd = request.getRequestDispatcher("login.html");
					// forwarding the request to Welcome.java
					rd.include(request, response);
				}
				out.println("</body></html>");

				// Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
            }//end of esle if 2 

            else
            {
                out.println("<h3 style=\"text-align:center\">Invalid Credentials!</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				// forwarding the request to Welcome.java
				rd.include(request, response);

            }//else

		} 

		catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
		} 
		catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
		} 

	} 
}