package gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "demo@123");
			PreparedStatement pst = con.prepareStatement("SELECT * FROM std1");
			ResultSet rs = pst.executeQuery();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<table border='1'>");
			out.println("<tr><th>Name</th><th>Roll Number</th></tr>");

			while (rs.next()) 
			{
				String name = rs.getString("name"); 
				String rnumber = rs.getString("rnumber"); 
				
				out.println("<tr>");
				out.println("<td>" + name + "</td>");
				out.println("<td>" + rnumber + "</td>");
				out.println("</tr>");
			}

			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

			
		} 
		catch (Exception e)
		{
			out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
