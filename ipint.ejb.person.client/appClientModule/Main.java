import java.util.Iterator;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ipint.ejb.person.PersonCatalogRemote;
import ipint.ejb.person.entities.Person;

public class Main {
	public static void main (String[] args) {
		try {
			// création du "contexte initial" = de la connexion à l'annuaire du serveur
			InitialContext context = new InitialContext();
			// requête sur le nom de la ressource que l'on veut, ici notre EJB
			PersonCatalogRemote monCatalog =(PersonCatalogRemote)context.lookup("ipint.ejb.person.PersonCatalogRemote");
			monCatalog.createPerson("Maxime", "Gidon", 22);
			List<Person> myPersons = monCatalog.listPerson();
            Iterator it = myPersons.iterator();
            while(it.hasNext()) {
                    System.out.println(it.next());
            }
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public Main() { super(); }
}