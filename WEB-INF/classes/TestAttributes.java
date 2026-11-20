import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestAttributes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String scope = req.getParameter("scope");
        String action = req.getParameter("action");
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out = rep.getWriter();
        out.println("<html><body>");
        if (scope != null && action != null) {
            if (scope.equals("session")) {
                HttpSession session = req.getSession(true);
                if (action.equals("add")) {
                    session.setAttribute("user", "ali");
                } else if (action.equals("replace")) {
                    session.setAttribute("user", "salah");
                } else if (action.equals("remove")) {
                    session.removeAttribute("user");
                }
            } else if (scope.equals("application")) {
                ServletContext ctx = getServletContext();
                if (action.equals("add")) {
                    ctx.setAttribute("test", "a");
                } else if (action.equals("replace")) {
                    ctx.setAttribute("test", "b");
                } else if (action.equals("remove")) {
                    ctx.removeAttribute("test");
                }
            } else if (scope.equals("request")) {
                req.setAttribute("test", "a");
                req.setAttribute("test", "b");
                req.removeAttribute("test");
            }
            out.println("<p>" + scope + " : " + action + "</p>");
        }
        out.println("<a href='TestAttributes?scope=session&action=add'>session add</a><br/>");
        out.println("<a href='TestAttributes?scope=session&action=replace'>session replace</a><br/>");
        out.println("<a href='TestAttributes?scope=session&action=remove'>session remove</a><br/>");
        out.println("<a href='TestAttributes?scope=application&action=add'>application add</a><br/>");
        out.println("<a href='TestAttributes?scope=application&action=replace'>application replace</a><br/>");
        out.println("<a href='TestAttributes?scope=application&action=remove'>application remove</a><br/>");
        out.println("<a href='TestAttributes?scope=request&action=all'>request add, replace, remove</a><br/>");
        out.println("</body></html>");
    }
}
