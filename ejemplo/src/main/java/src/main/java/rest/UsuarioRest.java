package src.main.java.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import src.main.java.logic.UsuarioLogic;
import src.main.java.model.Usuario;

@Path("usuarios")
public class UsuarioRest {

	@EJB
	private UsuarioLogic logic;

	@POST
	@Consumes("application/json")
	public Usuario crear(Usuario usuario) {
		return logic.create(usuario);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Usuario getById(@PathParam("id") Long id) {
		return logic.findById(id);
	}

	@DELETE
	public String eliminarCliente(Usuario usuario) {

		logic.delete(usuario);
		return "";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("")
	public List<Usuario> getAll() {
		return logic.findAllOrderedByName();
	}
}
