import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ReadCookie extends HttpServlet {
    @Override
        protected void doGet (HttpServletRequest req,HttpServletResponse rep) throws ServletException,IOException{
        Cookie [] c=req.getCookies();
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out=rep.getWriter();
        out.println("<table border='1'>");
        if (c!=null){
        for (Cookie x:c){
            out.println("<tr><td>"+x.getName()+"</td><td>"+x.getValue()+"</td></tr>");
        }
        out.println("</table>");}
        else{ out.println("pas de cookies");}

    }
}
