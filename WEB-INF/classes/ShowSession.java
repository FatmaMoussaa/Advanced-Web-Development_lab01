import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep)
            throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out = rep.getWriter();
        out.println("<html><body>");
        Integer nbVisites = (Integer) session.getAttribute("nbVisites");
        if (nbVisites == null) {
            nbVisites = 1;
            out.println("<h2>Welcome on my site</h2>");
        } else {
            nbVisites++;
            out.println("<h2>Welcome back</h2>");
        }
        session.setAttribute("nbVisites", nbVisites);
        out.println("<p>Number of visits: " + nbVisites + "</p>");
        Object actives = getServletContext().getAttribute("activeSessions");
        out.println("<p>Active sessions: " + actives + "</p>");
        String nom = (String) session.getAttribute("nom");
        String dateStr = (String) session.getAttribute("date");

        if (nom == null || dateStr == null || dateStr.isEmpty()) {
            out.println("<form method='POST' action='ShowSession'>");
            out.println("Full name: <input type='text' name='nom'><br/><br/>");
            out.println("Date of birth: <input type='date' name='date'><br/><br/>");
            out.println("<input type='submit' value='envoyer'>");
            out.println("</form>");
        } else {
            LocalDate birth = LocalDate.parse(dateStr);
            LocalDate today = LocalDate.now();
            LocalDate next = birth.withYear(today.getYear());
            if (next.isBefore(today)) {
                next = next.plusYears(1);
            }
            long nbJours = ChronoUnit.DAYS.between(today, next);
            out.println("<p>Hi, " + nom + ". There are " + nbJours
                    + " days to your birthday.</p>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rep)
            throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        session.setAttribute("nom", req.getParameter("nom"));
        session.setAttribute("date", req.getParameter("date"));
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out = rep.getWriter();
        out.println("<html><body>");
        out.println("<a href='ShowSession'>Visit again</a>");
        out.println("</body></html>");
    }
}