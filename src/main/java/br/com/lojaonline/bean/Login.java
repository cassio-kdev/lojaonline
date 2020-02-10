package br.com.lojaonline.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.lojaonline.model.Cliente;


public class Login {

	private Cliente cliente;

	public Cliente getCliente() {
		if(cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
