package br.com.lojaonline.service;

import java.util.List;

import br.com.lojaonline.dao.ClienteDAO;
import br.com.lojaonline.model.Cliente;

public class UsuarioServiceImpl implements UsuarioService {

	private ClienteDAO dao = new ClienteDAO();

	@Override
	public boolean salvaOuAtualiza(Cliente cliente) throws Exception {
		if (cliente != null) {
			return dao.savaOuAtualiza(cliente);
		}
		throw new Exception("Erro ao salvar ou atualizar ");
	}

	@Override
	public List<Cliente> pesquisaPorNome(String nome)  throws Exception {
		if(nome != null && !nome.isEmpty()) {
			return dao.pesquisaPorNome(nome);
		}
		return null;
	}

	@Override
	public boolean deleteCliente(Long idCliente) throws Exception {
		if(idCliente != null) {
			return dao.deleteCliente(idCliente);
		}
		return false;
	}

	@Override
	public List<Cliente> listaDeCliente() throws Exception {
		return dao.listaDeClientes();
	}

	@Override
	public Cliente pesquisaPorId(Long idCliente) throws Exception {
		if(idCliente != null) {
			return dao.pesquisaPorId(idCliente);
		}
		return null;
	}

}
