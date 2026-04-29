import java.sql.DriverManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/submitAchievement")
public class SubmitAchievementServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,
                      HttpServletResponse response)
                      throws ServletException, IOException {

String category=request.getParameter("category");
String title=request.getParameter("title");
String name=request.getParameter("name");
String prn=request.getParameter("prn");
String email=request.getParameter("email");
String description=request.getParameter("description");
String url=request.getParameter("url");

try{

Connection conn=DBConnection.getConnection();

String sql="INSERT INTO achievements(category,title,name,prn,email,description,proof_url) VALUES(?,?,?,?,?,?,?)";

PreparedStatement ps=conn.prepareStatement(sql);

ps.setString(1,category);
ps.setString(2,title);
ps.setString(3,name);
ps.setString(4,prn);
ps.setString(5,email);
ps.setString(6,description);
ps.setString(7,url);

ps.executeUpdate();

response.sendRedirect("index.html");

}catch(Exception e){
e.printStackTrace();
}

}
}