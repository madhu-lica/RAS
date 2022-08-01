import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class ReserveResource extends HttpServlet{
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

		String title = "Reserve Resource";
		String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
		out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title>\n"+
         "<link rel = \"stylesheet\" href = \"../css/cred.css\" type = \"text/css\">\n"+
         "<link rel = \"stylesheet\" href = \"../css/index.css\" type = \"text/css\">\n"+"</head>\n");

        //getting input from the login form
        //out.println("hii");
        String resourcename = request.getParameter("name");
        //out.println(resourcename);
		try {

            // Register JDBC driver
			Class.forName(JDBC_DRIVER);
			//Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);


			if(resourcename.equals("classroom")) //Classroom
            {
                String classname = request.getParameter("cname");
                //Integer capacity = request.getParameter("capacity");


				// Execute SQL query
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM classroom";
				ResultSet rs = stmt.executeQuery(sql);

				// Extract data from result set
				while(rs.next())
                {
					//Retrieve by column name
					String cname  = rs.getString("cname");
			        if(classname.equals(cname)) 
                    {
                        //out.println("1hii");
					    if((rs.getString("availability")).equals("yes"))
                        {
                            //out.println("hii");
                            String sql2,str="no";
				            //sql2 = "Update classroom set availability=? where cname="+classname;
                            //PreparedStatement st = conn.prepareStatement(sql2);
                            PreparedStatement st = conn.prepareStatement("UPDATE classroom SET availability = ? WHERE cname = ?");
                            //out.println("hiii222");
                            st.setString(1, str);
                            st.setString(2, classname);
                            st.executeUpdate();
                            out.println("<h1 style=\"text-align:center\">Classroom Reserved</h1>");
			                
                        }

                        else
                        {
                            out.println("<h1>Sorry, Classroom is not available.</h1>");
                        }
					}
				}
				
				out.println("</body></html>");

				// Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
			}//end of if

            //out.println(resourcename);
            else if(resourcename.equals("lab")) //Classroom
            {
                String labname = request.getParameter("lname");
                //Integer capacity = request.getParameter("capacity");


				// Execute SQL query
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM lab";
				ResultSet rs = stmt.executeQuery(sql);

				// Extract data from result set
				while(rs.next())
                {
					//Retrieve by column name
					String lname  = rs.getString("lname");
			        if(labname.equals(lname)) 
                    {
                        //out.println("1hii");
					    if((rs.getString("availability")).equals("yes"))
                        {
                            //out.println("hii");
                            String sql2,str="no";
				            //sql2 = "Update classroom set availability=? where cname="+classname;
                            //PreparedStatement st = conn.prepareStatement(sql2);
                            PreparedStatement st = conn.prepareStatement("UPDATE lab SET availability = ? WHERE lname = ?");
                            //out.println("hiii222");
                            st.setString(1, str);
                            st.setString(2, labname);
                            st.executeUpdate();
                            out.println("<h1 style=\"text-align:center\">Lab Reserved</h1>");
			                
                        }
                        else{
                            out.println("<h1>Sorry, Lab is not available.</h1>");
                        }
					}
				}
				
				out.println("</body></html>");

				// Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
			}//end of else if1


            else if(resourcename.equals("seminarhall")) //Classroom
            {
                String seminarhallname = request.getParameter("hname");
                //Integer capacity = request.getParameter("capacity");


				// Execute SQL query
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM seminarhall";
				ResultSet rs = stmt.executeQuery(sql);

				// Extract data from result set
				while(rs.next())
                {
					//Retrieve by column name
					String hname  = rs.getString("hname");
			        if(seminarhallname.equals(hname)) 
                    {
                        //out.println("1hii");
					    if((rs.getString("availability")).equals("yes"))
                        {
                            //out.println("hii");
                            String sql2,str="no";
				            //sql2 = "Update classroom set availability=? where cname="+classname;
                            //PreparedStatement st = conn.prepareStatement(sql2);
                            PreparedStatement st = conn.prepareStatement("UPDATE seminarhall SET availability = ? WHERE hname = ?");
                            //out.println("hiii222");
                            st.setString(1, str);
                            st.setString(2, seminarhallname);
                            st.executeUpdate();
                            out.println("<h1 style=\"text-align:center\">Seminar hall Reserved</h1>");
			                
                        }
                        else{
                            out.println("<h1>Sorry, seminar hall is not available.</h1>");
                        }
					}
				}
				
				out.println("</body></html>");

				// Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
			}//end of if


            else if(resourcename.equals("mic")) //Classroom
            {
                String micno = request.getParameter("mname");
                //Integer capacity = request.getParameter("capacity");


				// Execute SQL query
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM mic";
				ResultSet rs = stmt.executeQuery(sql);

				// Extract data from result set
				while(rs.next())
                {
					//Retrieve by column name
					String mname  = rs.getString("micno");
			        if(micno.equals(mname)) 
                    {
                        //out.println("1hii");
					    if((rs.getString("availability")).equals("yes"))
                        {
                            //out.println("hii");
                            String sql2,str="no";
				            //sql2 = "Update classroom set availability=? where cname="+classname;
                            //PreparedStatement st = conn.prepareStatement(sql2);
                            PreparedStatement st = conn.prepareStatement("UPDATE mic SET availability = ? WHERE micno = ?");
                            //out.println("hiii222");
                            st.setString(1, str);
                            st.setString(2, micno);
                            st.executeUpdate();
                            out.println("<h1 style=\"text-align:center\">Mic Reserved</h1>");
			                
                        }
                        else{
                            out.println("<h1>Sorry, Mic is not available.</h1>");
                        }
					}
				}
				
				out.println("</body></html>");

				// Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
			}//end of if


            else if(resourcename.equals("laptop")) //Classroom
            {
                String lapname = request.getParameter("lapname");
                //Integer capacity = request.getParameter("capacity");


				// Execute SQL query
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM laptop";
				ResultSet rs = stmt.executeQuery(sql);

				// Extract data from result set
				while(rs.next())
                {
					//Retrieve by column name
					String laptopname  = rs.getString("lapname");
			        if(lapname.equals(laptopname)) 
                    {
                        //out.println("1hii");
					    if((rs.getString("availability")).equals("yes"))
                        {
                            //out.println("hii");
                            String sql2,str="no";
				            //sql2 = "Update classroom set availability=? where cname="+classname;
                            //PreparedStatement st = conn.prepareStatement(sql2);
                            PreparedStatement st = conn.prepareStatement("UPDATE laptop SET availability = ? WHERE lapname = ?");
                            //out.println("hiii222");
                            st.setString(1, str);
                            st.setString(2, laptopname);
                            st.executeUpdate();
                            out.println("<h1 style=\"text-align:center\">Laptop Reserved</h1>");
			                
                        }
                        else{
                            out.println("<h1>Sorry, Laptop is not available.</h1>");
                        }
					}
				}
				
				out.println("</body></html>");

				// Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
			}//end of if
            

            else if(resourcename.equals("projector")) //Classroom
            {
                String projectorname = request.getParameter("pname");
                //Integer capacity = request.getParameter("capacity");


				// Execute SQL query
				Statement stmt = conn.createStatement();
				String sql;
				sql = "SELECT * FROM projector";
				ResultSet rs = stmt.executeQuery(sql);

				// Extract data from result set
				while(rs.next())
                {
					//Retrieve by column name
					String pname  = rs.getString("projno");
			        if(projectorname.equals(pname)) 
                    {
                        //out.println("1hii");
					    if((rs.getString("availability")).equals("yes"))
                        {
                            //out.println("hii");
                            String sql2,str="no";
				            //sql2 = "Update classroom set availability=? where cname="+classname;
                            //PreparedStatement st = conn.prepareStatement(sql2);
                            PreparedStatement st = conn.prepareStatement("UPDATE projector SET availability = ? WHERE projno = ?");
                            //out.println("hiii222");
                            st.setString(1, str);
                            st.setString(2, projectorname);
                            st.executeUpdate();
                            out.println("<h1 style=\"text-align:center\">Projector Reserved</h1>");
			                
                        }
                        else{
                            out.println("<h1>Sorry, Projector is not available.</h1>");
                        }
					}
				}
				
				out.println("</body></html>");

				// Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
			}//end of if

          




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