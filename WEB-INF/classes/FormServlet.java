import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
public class FormServlet extends HttpServlet{
    @Override
     protected void doPost(HttpServletRequest req ,HttpServletResponse rep) throws ServletException,IOException{
        String nom=req.getParameter("nom");
        String prenom=req.getParameter("prenom");
        String date =req.getParameter("date");
        String sexe=req.getParameter("sexe");
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out=rep.getWriter();
        Cookie n=new Cookie("NOM",nom);
        Cookie p=new Cookie("PRENOM",prenom);
        Cookie d=new Cookie("DATE",date);
        Cookie s=new Cookie("SEXE",sexe);
        rep.addCookie(n);
        rep.addCookie(p);
        rep.addCookie(d);
        rep.addCookie(s);
        out.println("<table border='1'>");
        out.println("<tr><td>NOM</td><td>"+nom+"</td></tr>");
        out.println("<tr><td>PRENOM</td><td>"+prenom+"</td></tr>");
        out.println("<tr><td>DATE</td><td>"+date+"</td></tr>");
        out.println("<tr><td>SEXE</td><td>"+sexe+"</td></tr>");
        out.println("</table>");
        out.println("<a href='http://localhost:8082/Lab01/ReadCookie'/> voir vos cookies");

    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse rep) throws ServletException,IOException{
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out=rep.getWriter();
        out.println("Bienvenue");
    }
}