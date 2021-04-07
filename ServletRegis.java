import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServletRegis extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	    String s1=request.getParameter("un");
	    String s2=request.getParameter("up");
		String s3=request.getParameter("email");
	    String s4=request.getParameter("date");
		String s5=request.getParameter("gender");
	    String s6=request.getParameter("num");
       
	   
	   PrintWriter out=response.getWriter();
        out.println("<html>");
         
         try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			String db_url="jdbc:mysql://localhost:3307/onlineexam?useSSL=false";
			String db_name="root";
			String db_pass="root";
			
			Connection con=DriverManager.getConnection(db_url,db_name,db_pass);
			 
			Statement st= con.createStatement();
			  String q="insert into regis values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"');";
			 st.executeUpdate(q);
			 response.sendRedirect("Login.html"); 
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