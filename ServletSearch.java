import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServletSearch extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
       
	   
	   PrintWriter out=response.getWriter();
        out.println("<html>");
		//html css design
		//------------------------------------------------------------------------------------------
		out.println("</head><link rel='stylesheet' href='xyz.css'></head><body><div id='mymenu'><ul><li>Home</li><li> <a href='Insert.html'>Insert</a></li><li> <a href='search'>Search</a></li><li> <a href='ShowAll'>ShowAll</a></li>	<li> <a href='update'>Update</a></li><li> <a href='Delete.html'>Delete</a></li><li><a href='Login.html'>LogOut</a></li><li><a href='About.html'>About</a></li></ul></div><div id='data'><form action='search' method='get'>");
          //-------------------------------------------------------------------------------------------
		 out.println("<center><table cellpadding='12px' width='500'><caption style='color:white;font-weight:bold;font-size:25px;'>Search Data Here</caption><tr><td colspan='2'>Enter Roll</td><td colspan='3'><input type='text' name='u1' placeholder='Enter Roll'></td> </tr><tr><th colspan='5'><input type='submit' value='Search' class='B'></th></tr>");
        
	    String s1=request.getParameter("u1");         
		try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			String db_url="jdbc:mysql://localhost:3307/onlineexam?useSSL=false";
			String db_name="root";
			String db_pass="root";
			
			Connection con=DriverManager.getConnection(db_url,db_name,db_pass);
			 
			Statement st= con.createStatement();
			  String q="select * from insmarks where URoll='"+s1+"'";
			  ResultSet rs=st.executeQuery(q);
			 
				 
			 if(rs.next())
			 {
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>"); 
			    
			 } 
			 else
			 {
				 out.println("<tr><td colspan='5'>Not Found</td></tr>");
			 }
			 out.println("</table></center>");
			 out.println("</form>");
			con.close();
		 }
         catch(Exception e1)
		 {
			 out.println(e1);
		 }		 
		
		out.println("</body>");
		out.println("</html>");
	
	}

}