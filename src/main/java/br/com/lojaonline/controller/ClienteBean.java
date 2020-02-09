package br.com.lojaonline.controller;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.lojaonline.model.Cliente;
import br.com.lojaonline.service.UsuarioService;
import br.com.lojaonline.service.UsuarioServiceImpl;

@Named
@ViewScoped
public class ClienteBean {

	private UsuarioService service = new UsuarioServiceImpl();
	
	public boolean salvaOuAtualiza(Cliente cliente) {
		try {
			service.salvaOuAtualiza(cliente);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Cliente> lista() {
		try {
			return service.listaDeCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Cliente pesquisaPorId(Long idCliente) {
		try {
			return service.pesquisaPorId(idCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Cliente> pesquisaPorNome(String nome) {
		try {
			return service.pesquisaPorNome(nome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
