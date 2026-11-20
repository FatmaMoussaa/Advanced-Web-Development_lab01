import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ApplicationAttributeListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent e) {
        System.out.println("Application : attribut ajoute " + e.getName() + " = " + e.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent e) {
        System.out.println("Application : attribut modifie " + e.getName() + " (ancienne valeur = " + e.getValue() + ")");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent e) {
        System.out.println("Application : attribut supprime " + e.getName() + " = " + e.getValue());
    }
}
