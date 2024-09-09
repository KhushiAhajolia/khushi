package gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Delete() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String rnumber = request.getParameter("rnumber");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "demo@123");
            PreparedStatement pst = con.prepareStatement("DELETE FROM std1 WHERE rnumber = ?");
            pst.setString(1, rnumber); 
            pst.executeUpdate();
            
            out.println("Data Deleted!!");
        }
        catch (Exception e)
        {
            out.println(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
