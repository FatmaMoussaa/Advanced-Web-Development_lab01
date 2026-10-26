import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListItems extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse rep)
            throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        if (items == null) {
            items = new ArrayList<String>();
            session.setAttribute("items", items);
        }
        String newItem = req.getParameter("newItem");
        if (newItem != null && !newItem.trim().isEmpty()) {
            items.add(newItem.trim());}

        rep.sendRedirect("ListItems");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep)
            throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        rep.setContentType("text/html;charset=UTF-8");
        PrintWriter out = rep.getWriter();
        out.println("<html><body>");
        out.println("<h2>Your items</h2>");

        if (items == null || items.isEmpty()) {
            out.println("<p>No items yet.</p>");
        } else {
            out.println("<ul>");
            for (String item : items) {
                out.println("<li>" + item + "</li>");
            }
            out.println("</ul>");
        }
        out.println("<a href='items.html'>Add another item</a>");
        out.println("</body></html>");
    }
}