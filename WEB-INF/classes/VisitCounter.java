import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VisitCounter extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse rep) throws ServletException,IOException{
        Cookie c=new Cookie("nbvisites","1");
        int nbvisites=1;
        Cookie [] cookies=req.getCookies();
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out=rep.getWriter();
        if(cookies!=null){
            for (Cookie x:cookies){
                if (x.getName().equals("nbvisites")) {
                    try {
                        nbvisites = Integer.parseInt(x.getValue()) + 1;
                    } catch (NumberFormatException e) {
                        nbvisites = 1;
                    }
                }
            }
        }
        c.setValue(String.valueOf(nbvisites));
        rep.addCookie(c);
        out.println("<html><body>");
        out.println("<p>Nombre de visites : " + nbvisites + "</p>");
        out.println("</body></html>");
    }
}