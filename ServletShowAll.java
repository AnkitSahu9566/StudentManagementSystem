import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServletShowAll extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	    String s1=request.getParameter("u1");
	    String s2=request.getParameter("u2");
		String s3=request.getParameter("u3");
	    String s4=request.getParameter("u4");
		String s5=request.getParameter("u5"); 
       
	   
	   PrintWriter out=response.getWriter();
        out.println("<html>");
		//html css design
		//------------------------------------------------------------------------------------------
		out.println("</head><link rel='stylesheet' href='xyz.css'></head><body><div id='mymenu'><ul><li>Home</li><li> <a href='Insert.html'>Insert</a></li><li> <a href='search'>Search</a></li><li> <a href='ShowAll'>ShowAll</a></li>	<li> <a href='update'>Update</a></li><li> <a href='Delete.html'>Delete</a></li><li><a href='Login.html'>LogOut</a></li><li><a href='About.html'>About</li></ul></div><div id='data'><form action='' method='get'>");
          //-------------------------------------------------------------------------------------------
		 out.println("<center><table cellpadding='12px' width='500'><caption style='color:white;font-weight:bold;font-size:25px;'>Inserted Data Here</caption>");
         try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			String db_url="jdbc:mysql://localhost:3307/onlineexam?useSSL=false";
			String db_name="root";
			String db_pass="root";
			
			Connection con=DriverManager.getConnection(db_url,db_name,db_pass);
			 
			Statement st= con.createStatement();
			  String q="select * from insmarks;";
			  ResultSet rs=st.executeQuery(q);
			 
				 
			 while(rs.next())
			 {
				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td></tr>"); 
			    
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