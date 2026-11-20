import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent e) {
        System.out.println("Session : attribut ajoute " + e.getName() + " = " + e.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent e) {
        System.out.println("Session : attribut modifie " + e.getName() + " (ancienne valeur = " + e.getValue() + ")");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent e) {
        System.out.println("Session : attribut supprime " + e.getName() + " = " + e.getValue());
    }
}
