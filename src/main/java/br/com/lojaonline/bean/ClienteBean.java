package br.com.lojaonline.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.lojaonline.model.Cliente;
import br.com.lojaonline.service.UsuarioService;
import br.com.lojaonline.service.UsuarioServiceImpl;
import br.com.lojaonline.util.UtilMensagens;

@Named
@ViewScoped
public class ClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Cliente> clientes;
	private Cliente cliente;
	private UsuarioService service = new UsuarioServiceImpl();
	
	
	public String salvaOuAtualiza(Cliente cliente) {
		
		try {
			service.salvaOuAtualiza(cliente);
			UtilMensagens.mensagemInformacao(cliente.getNome() + cliente.getIdUsuario() == null ? " cadastrado " : " alterado " + "com sucesso");
			
			return "/restrito/index?faces-redirect=true";
		} catch (Exception e) {
			UtilMensagens.mensagemErro("Erro ao realizar a tarefa " +  e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public void gravar(Cliente cliente) {
		
		try {
			if(service.salvaOuAtualiza(cliente)) {
				UtilMensagens.mensagemInformacao("Salvo com sucesso");
			}else {
				UtilMensagens.mensagemErro("Não foi possível salva o cliente");
			}
			
		} catch (Exception e) {
			UtilMensagens.mensagemErro("Erro ao realizar a tarefa " +  e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void limparCampos() {
		cliente = new Cliente();
	}
	
	@PostConstruct
	public void lista() {
		try {
			clientes = service.listaDeCliente();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pesquisaPorId(Long idCliente) {
		try {
			cliente =  service.pesquisaPorId(idCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void pesquisaPorNome(String nome) {
		try {
			clientes =  service.pesquisaPorNome(nome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cliente getCliente() {
		if(cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
