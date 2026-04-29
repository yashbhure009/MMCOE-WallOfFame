import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class GetAchievementsServlet extends HttpServlet{

protected void doGet(HttpServletRequest request,
                     HttpServletResponse response)
                     throws ServletException, IOException{

response.setContentType("application/json");

PrintWriter out=response.getWriter();

Connection conn=DBConnection.getConnection();

Statement st=conn.createStatement();

ResultSet rs=st.executeQuery("SELECT * FROM achievements WHERE status='Approved'");

out.print("[");

boolean first=true;

while(rs.next()){

if(!first) out.print(",");

out.print("{");

out.print("\"title\":\""+rs.getString("title")+"\",");
out.print("\"category\":\""+rs.getString("category")+"\",");
out.print("\"name\":\""+rs.getString("name")+"\",");
out.print("\"description\":\""+rs.getString("description")+"\"");

out.print("}");

first=false;

}

out.print("]");

}
}