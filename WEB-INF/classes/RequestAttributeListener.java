import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent e) {
        System.out.println("Requete : attribut ajoute " + e.getName() + " = " + e.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent e) {
        System.out.println("Requete : attribut modifie " + e.getName() + " (ancienne valeur = " + e.getValue() + ")");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent e) {
        System.out.println("Requete : attribut supprime " + e.getName() + " = " + e.getValue());
    }
}
