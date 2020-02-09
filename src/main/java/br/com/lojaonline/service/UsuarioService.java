package br.com.lojaonline.service;

import java.util.List;

import br.com.lojaonline.model.Cliente;

public interface UsuarioService {

	boolean salvaOuAtualiza(Cliente cliente) throws Exception;
	Cliente pesquisaPorId(Long idCliente) throws Exception;
	List<Cliente> pesquisaPorNome(String nome)  throws Exception;
	boolean deleteCliente(Long idCliente) throws Exception;
	List<Cliente> listaDeCliente() throws Exception;
}
