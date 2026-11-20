import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ActiveSessionListener implements HttpSessionListener {

    private static final AtomicInteger compteur = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int n = compteur.incrementAndGet();
        se.getSession().getServletContext().setAttribute("activeSessions", n);
        System.out.println("Session creee : " + se.getSession().getId() + " | sessions actives : " + n);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        int n = compteur.decrementAndGet();
        se.getSession().getServletContext().setAttribute("activeSessions", n);
        System.out.println("Session detruite : " + se.getSession().getId() + " | sessions actives : " + n);
    }
}
