import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ServletLogin extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	    String s1=request.getParameter("un");
		
	    String s2=request.getParameter("up");
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
			  String q="select * from regis where UName='"+s1+"' AND UPass='"+s2+"';";
			 ResultSet re=st.executeQuery(q);
			 if(re.next())
			 {
			  response.sendRedirect("Mymenu.html");
			 }
			 else
			 {
				out.println("<h1>Enter Valid name & pass</h1>"); 
			 }
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

//set classpath=C:\Program Files\Apache Software Foundation\Tomcat 9.0\lib\servlet-api.jar;.;%classpath%