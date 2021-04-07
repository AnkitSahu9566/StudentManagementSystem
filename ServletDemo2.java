import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletDemo2 extends HttpServlet
{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	    String s1=request.getParameter("un");
		
	    String s2=request.getParameter("up");
       PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Name</th>");
        out.println("<th>Pass</th>");
        out.println("</tr>");
        out.println("<tr>");
		out.println("<td>"+s1+"</th>");
        out.println("<td>"+s2+"</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
		out.println("</html>");
	
	}

}