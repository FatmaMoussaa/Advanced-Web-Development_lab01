import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out = rep.getWriter();
        out.println("<html><body>");
        if (session == null) {
            out.println("<p>Pas de session.</p>");
        } else if ("remove".equals(req.getParameter("mode"))) {
            session.removeAttribute("userObj");
            out.println("<p>SessionUser retire de la session.</p>");
        } else {
            session.invalidate();
            out.println("<p>Session invalidee.</p>");
        }
        out.println("<a href='login.html'>Login</a>");
        out.println("</body></html>");
    }
}
