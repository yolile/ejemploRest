/**
 * 
 */
package src.main.java.logic;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import src.main.java.model.Usuario;

/**
 * @author Yohanna Lisnichuk
 *
 */
@Stateless
@LocalBean

public class UsuarioLogic {
	@PersistenceContext(unitName = "PersistenciaAppPU")
	private EntityManager em;

	public Usuario findById(Long id) {
		return em.find(Usuario.class, id);
	}

	public Usuario create(Usuario usuario) {
		return em.merge(usuario);
	}

	public void delete(Usuario usuario) {
		em.remove(usuario);
	}

	public List<Usuario> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = cb.createQuery(Usuario.class);
		Root<Usuario> member = criteria.from(Usuario.class);
		criteria.select(member).orderBy(cb.asc(member.get("nombre")));
		return em.createQuery(criteria).getResultList();
	}
}
