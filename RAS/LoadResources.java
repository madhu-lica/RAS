import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class LoadResources extends HttpServlet{
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
		String title = "Load resouces";
		String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
		out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title>\n"+
         "<link rel = \"stylesheet\" href = \"../css/cred.css\" type = \"text/css\">\n"+
         "<link rel = \"stylesheet\" href = \"../css/index.css\" type = \"text/css\">\n"+"</head>\n");

        String resourcetype = request.getParameter("resourcetype");

		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			//Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			

            if(resourcetype.equals("classroom"))
            {
                // Execute SQL query
			    Statement stmt = conn.createStatement();
			    String sql;
			    sql = "SELECT * FROM classroom";
			    ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			    out.println("<br><h1 style=\"text-align:center\">Classrooms</h1><br><br>\n");
			    out.println("<table style=\"border-collapse:collapse;width:100%;border:3px solid black;text-align:center\"><tr><th>Classrom Name</th><th>Capacity</th><th>Availability</th></tr><br>\n");
			   
                while(rs.next()){
				//Retrieve by column name
				String cname  = rs.getString("cname");
			    Integer capacity = rs.getInt("capacity");
                String availability = rs.getString("availability");
                out.println("<tr><td>"+cname+"</td><td>"+capacity+"</td><td>"+availability+"</td></tr>\n");

                }
                out.println("</table>\n");
                rs.close();
    			stmt.close();
			}//classroom

			else if(resourcetype.equals("lab"))
            {
                // Execute SQL query
			    Statement stmt = conn.createStatement();
			    String sql;
			    sql = "SELECT * FROM lab";
			    ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
				out.println("<br><h1 style=\"text-align:center\">Lab</h1><br><br>\n");
			    out.println("<table style=\"border-collapse:collapse;width:100%;border:3px solid black;text-align:center\"><tr><th>Lab Name</th><th>Capacity</th><th>Availability</th></tr><br>\n");
			   
                while(rs.next()){
				//Retrieve by column name
				String lname  = rs.getString("lname");
			    Integer capacity = rs.getInt("capacity");
                String availability = rs.getString("availability");
                out.println("<tr><td>"+lname+"</td><td>"+capacity+"</td><td>"+availability+"</td></tr>\n");

                }
                out.println("</table>\n");
                rs.close();
    			stmt.close();
			}//labs

            else if(resourcetype.equals("seminarhall"))
            {
                // Execute SQL query
			    Statement stmt = conn.createStatement();
			    String sql;
			    sql = "SELECT * FROM seminarhall";
			    ResultSet rs = stmt.executeQuery(sql);

			// Extract data from result set
			    out.println("<br><h1 style=\"text-align:center\">Seminar Hall</h1><br><br>\n");
			    out.println("<table style=\"border-collapse:collapse;width:100%;border:3px solid black;text-align:center\"><tr><th>Seminar Hall Name</th><th>Capacity</th><th>Availability</th></tr><br>\n");
			   
                while(rs.next()){
				//Retrieve by column name
				String hname  = rs.getString("hname");
			    Integer capacity = rs.getInt("capacity");
                String availability = rs.getString("availability");
                out.println("<tr><td>"+hname+"</td><td>"+capacity+"</td><td>"+availability+"</td></tr>\n");

                }
                out.println("</table>\n");
                rs.close();
    			stmt.close();
			}//seminar hall

            else if(resourcetype.equals("mic"))
            {
                // Execute SQL query
			    Statement stmt = conn.createStatement();
			    String sql;
			    sql = "SELECT * FROM mic";
			    ResultSet rs = stmt.executeQuery(sql);

			    // Extract data from result set
				out.println("<br><h1 style=\"text-align:center\">Mic</h1><br><br>\n");
			    out.println("<table style=\"border-collapse:collapse;width:100%;border:3px solid black;text-align:center\"><tr><th>Lab Name</th><th>Availability</th></tr><br>\n");
			   
                while(rs.next()){
				//Retrieve by column name
				String micno  = rs.getString("micno");
                String availability = rs.getString("availability");
                out.println("<tr><td>"+micno+"</td><td>"+availability+"</td></tr>\n");

                }
                out.println("</table>\n");
                rs.close();
    			stmt.close();
			}//

            else if(resourcetype.equals("laptop"))
            {
                // Execute SQL query
			    Statement stmt = conn.createStatement();
			    String sql;
			    sql = "SELECT * FROM laptop";
			    ResultSet rs = stmt.executeQuery(sql);

			    // Extract data from result set
				out.println("<br><h1 style=\"text-align:center\">Laptops</h1><br><br>\n");
			    out.println("<table style=\"border-collapse:collapse;width:100%;border:3px solid black;text-align:center\"><tr><th>Lab Name</th><th>Availability</th></tr><br>\n");
			   
                while(rs.next()){
				//Retrieve by column name
				String lapno  = rs.getString("lapno");
                String availability = rs.getString("availability");
                out.println("<tr><td>"+lapno+"</td><td>"+availability+"</td></tr>\n");

                }
                out.println("</table>\n");
                rs.close();
    			stmt.close();
			}//

            else if(resourcetype.equals("projector"))
            {
                // Execute SQL query
			    Statement stmt = conn.createStatement();
			    String sql;
			    sql = "SELECT * FROM projector";
			    ResultSet rs = stmt.executeQuery(sql);

			    // Extract data from result set
				out.println("<br><h1 style=\"text-align:center\">Projectors</h1><br><br>\n");
			    out.println("<table style=\"border-collapse:collapse;width:100%;border:3px solid black;text-align:center\"><tr><th>Lab Name</th><th>Availability</th></tr><br>\n");
			   
                while(rs.next()){
				//Retrieve by column name
				String projno  = rs.getString("projno");
                String availability = rs.getString("availability");
                out.println("<tr><td>"+projno+"</td><td>"+availability+"</td></tr>\n");

                }
                out.println("</table>\n");
                rs.close();
			    stmt.close();
			}//

            else{
                //do nothing :)
            }


			out.println("</body></html>");

			// Clean-up environment
			
			conn.close();
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