import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServletUpdate extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
       
	   
	   PrintWriter out=response.getWriter();
        out.println("<html>");
		//html css design
		//------------------------------------------------------------------------------------------
		out.println("</head><link rel='stylesheet' href='xyz.css'></head><body><div id='mymenu'><ul><li>Home</li><li> <a href='Insert.html'>Insert</a></li><li> <a href='search'>Search</a></li><li> <a href='ShowAll'>ShowAll</a></li>	<li> <a href='update'>Update</a></li><li> <a href='Delete.html'>Delete</a></li><li><a href='Login.html'>LogOut</a></li><li><a href='About.html'>About</a></li></ul></div><div id='data'><form action='update' method='get'>");
          //-------------------------------------------------------------------------------------------
		 out.println("<center><table cellpadding='12px' width='500'><caption style='color:white;font-weight:bold;font-size:25px;'>Upadte Data Here</caption><tr><td>Enter Roll</td><td><input type='text' name='u1' placeholder='Enter Roll'></td><td><input type='submit' value='Search' class='B'></td></tr>");
        out.println("<tr><td>Enter Name</td><td colspan='2'><input type='text' name='u2' placeholder='Enter Name'></td></tr><tr><td>Physics</td><td colspan='2'><input type='integer' name='u3' placeholder='Physics'></td></tr><tr><td>Chemistry</td><td colspan='2'><input type='integer' name='u4' placeholder='chemistry'></td></tr><tr><td>Maths</td><td colspan='2'><input type='integer' name='u5' placeholder='Maths'></td></tr><tr><th colspan='2'><input type='submit' value='Update' class='B'></th></tr>");
			  
	    String s1=request.getParameter("u1");         
		try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			String db_url="jdbc:mysql://localhost:3307/onlineexam?useSSL=false";
			String db_name="root";
			String db_pass="root";
			
			Connection con=DriverManager.getConnection(db_url,db_name,db_pass);
			 
			Statement st= con.createStatement();
			  // String q="select * from insmarks where URoll='"+s1+"'";
			  // ResultSet rs=st.executeQuery(q);
			  
               String s2=request.getParameter("u2");  
			  String s3=request.getParameter("u3");  
			  String s4=request.getParameter("u4");  
			  String s5=request.getParameter("u5");  
			  String q="update insmarks set UName='"+s2+"',UPhy='"+s3+"',UChem='"+s4+"',UMath='"+s5+"'where URoll='"+s1+"';";
			  st.executeUpdate(q);
			 // response.sendRedirect("ShowAll"); 
			  //----------------------------------------------------
			  //html code
			   
			//------------------------------------
			  
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
