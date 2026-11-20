import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("appName", "ING1 Web Application");
        System.out.println("Application demarree : " + ctx.getAttribute("appName"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application arretee");
    }
}
