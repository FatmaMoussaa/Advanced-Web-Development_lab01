import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoggingFilter implements Filter {

    private String prefix;

    @Override
    public void init(FilterConfig x) {
        prefix = x.getInitParameter("logPrefix");
        System.out.println(prefix + "initialisation du Filtre LoggingFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        long debut = System.nanoTime();
        System.out.println(prefix + "Avant chain.doFilter LoggingFilter : " + req.getRequestURL());
        chain.doFilter(request, response);
        long fin = System.nanoTime();
        System.out.println(prefix + "Après chain.doFilter LoggingFilter");
        System.out.println(prefix + "Temps d'execution : " + (fin - debut) / 1000000.0 + " ms");
    }

    @Override
    public void destroy() {
        System.out.println(prefix + "destroy du Filtre LoggingFilter");
    }
}
