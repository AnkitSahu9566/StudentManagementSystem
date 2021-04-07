import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServletInsert extends HttpServlet
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
         
         try
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
			String db_url="jdbc:mysql://localhost:3307/onlineexam?useSSL=false";
			String db_name="root";
			String db_pass="root";
			
			Connection con=DriverManager.getConnection(db_url,db_name,db_pass);
			 
			Statement st= con.createStatement();
			  String q="insert into insmarks values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"');";
			 st.executeUpdate(q); 
			 response.sendRedirect("ShowAll"); 
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