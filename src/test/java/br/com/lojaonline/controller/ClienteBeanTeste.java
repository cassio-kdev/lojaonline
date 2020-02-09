package br.com.lojaonline.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.lojaonline.model.Cliente;

public class ClienteBeanTeste {
	Long idCliente = 1l, idCliente2 = 2l, idCliente3 = 3l;
	private Cliente cliente;
	private List<Cliente> clientes = null;
	
	private ClienteBean clienteBean = new ClienteBean();

	@Before
	public void setUp() {
		
		cliente = new Cliente( "teste ", "12345", "testelogin", "teste@gmail.com");
//		cliente = new Cliente( "Cássio Alves ", "5456", "alves", "alves@gmail.com");
//		cliente = new Cliente( "Cássio", "54");

	}
	
	@After
	public void limpaCliente() {
		cliente = null;
		clientes = null;
	}

	@Test
	public void testeSalvaOuAtualiza() {
		boolean salvaOuAtualiza = clienteBean.salvaOuAtualiza(cliente);
		
		assertTrue(salvaOuAtualiza);
	}
	
	@Test
	public void testePesquisaPorId() {
		cliente =  clienteBean.pesquisaPorId(idCliente3);
			System.out.println(cliente.toString());
			assertNotNull(cliente);
	}
	
	@Test
	public void testeListaCliente() {
		List<Cliente> lista = clienteBean.lista();
		
		assertNotNull(lista);
	}
	
	@Test
	public void testePesquisaPorNome() {
		clientes = clienteBean.pesquisaPorNome("Cássio");
		
		assertNotNull(cliente);
	}
}
