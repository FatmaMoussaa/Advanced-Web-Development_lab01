import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig x) {
        System.out.println("initialisation du Filtre SecurityFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        System.out.println("Avant chain.doFilter SecurityFilter");
        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            System.out.println("Acces refuse, redirection vers login.html");
            rep.sendRedirect(req.getContextPath() + "/login.html");
        }
        System.out.println("Après chain.doFilter SecurityFilter");
    }

    @Override
    public void destroy() {
        System.out.println("destroy du Filtre SecurityFilter");
    }
}
