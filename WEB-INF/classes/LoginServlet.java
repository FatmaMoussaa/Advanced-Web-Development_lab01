import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String username = req.getParameter("username");
        HttpSession session = req.getSession(true);
        session.setAttribute("user", username);
        session.setAttribute("userObj", new SessionUser(username));
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out = rep.getWriter();
        out.println("<html><body>");
        out.println("<p>Bienvenue " + username + ", vous etes connecte.</p>");
        out.println("<a href='items.html'>Aller vers items.html</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        rep.sendRedirect("login.html");
    }
}
