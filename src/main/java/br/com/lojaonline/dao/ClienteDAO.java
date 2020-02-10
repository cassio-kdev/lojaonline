package br.com.lojaonline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.lojaonline.model.Cliente;
import br.com.lojaonline.util.JpaFactory;

@Transactional
public class ClienteDAO {
	private EntityManager em;

	public ClienteDAO() {
		em = JpaFactory.getEntityManager();
	}

	public boolean savaOuAtualiza(Cliente cliente) throws Exception {
		boolean sucesso = false;
		try {
			if(!em.isOpen())
				em = JpaFactory.getEntityManager();
			em.getTransaction().begin();
			if (cliente.getIdUsuario() == null) {
				em.persist(cliente);

			} else {
				em.merge(cliente);
			}
			em.getTransaction().commit();
			sucesso = true;

		} catch (Exception ex) {
			em.getTransaction().rollback();
			throw ex;
		} finally {
			em.close();
		}
		return sucesso;
	}

	public boolean deleteCliente(Long idCliente) throws Exception {
		boolean sucesso = false;
		try {
			em.getTransaction().begin();
			em.remove(idCliente);
			em.getTransaction().commit();
			sucesso = true;
		} catch (Exception ex) {
			throw ex;
		} finally {
			em.close();
		}
		return sucesso;
	}

	public List<Cliente> listaDeClientes() throws Exception {
		List<Cliente> lista = null;
		try {
		em.getTransaction().begin();
		lista = em.createQuery("from Cliente order by nome").getResultList();
		}catch(Exception ex) {
			throw ex;
		}finally {
			em.close();
		}
		return lista;
	}

	public Cliente pesquisaPorId(Long idCliente) throws Exception {

		return em.find(Cliente.class, idCliente);
	}

	public List<Cliente> pesquisaPorNome(String nome) throws Exception {
		List<Cliente> retorno = null;
		String hql = "from Cliente c where c.nome like :nome";
		 retorno = em.createQuery(hql, Cliente.class).setParameter("nome", "%"+nome+"%").getResultList();
		return retorno;
		
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
