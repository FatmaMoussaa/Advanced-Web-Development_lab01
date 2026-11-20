import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionUser implements HttpSessionBindingListener {

    private String username;

    public SessionUser(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("SessionUser lie a la session : " + username);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("SessionUser retire de la session : " + username);
    }
}
