import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter("/*")
public  class LoggingFilter implements Filter {



    @Override
    public void init(FilterConfig x){
        String prefix = x.getInitParameter(x.getFilterName());
        System.out.println("initialisation du Filtre LoggingFilter"+prefix);
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("L'url de cette requete : "+req.getRequestURL());
        chain.doFilter(request,response);
        System.out.println("Après Filtre LoggingFilter ");
    }
    @Override
    public void destroy() {

        System.out.println("destroy du Filtre LoggingFilter");
    }


}