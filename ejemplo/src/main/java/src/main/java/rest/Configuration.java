package src.main.java.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("rest")
public class Configuration extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
		try {
			Class jsonProvider = Class
					.forName("org.jboss.resteasy.resteasy-jackson-provider");

			resources.add(jsonProvider);
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(getClass().getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(UsuarioRest.class);

	}
}
