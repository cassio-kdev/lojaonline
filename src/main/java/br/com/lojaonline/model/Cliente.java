package br.com.lojaonline.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Size(max = 50, message = "O nome dever ter no máximo 50 caracteres")
	@Column(nullable = false, length = 50)
	private String nome;

	@Size(min = 6, max = 8, message = "A senha dever ter entre 6 e 8 caracteres")
	@Column(nullable = false, length = 8)
	private String senha;

	@Size(max = 20, message = "O nome dever ter no máximo 50 caracteres")
	@NotNull(message = "Informe o login")
	@Column(nullable = false, length = 20)
	private String login;

	@Size(max = 50, message = "O nome dever ter no máximo 50 caracteres")
	@NotNull(message = "Informe o email")
	@Column(nullable = false, length = 50)
	private String email;

	public Cliente() {}
	
	public Cliente(String senha, String login) {
		this.senha = senha;
		this.login = login;
	}
	public Cliente(Long idUsuario, String nome, String senha, String login,  String email) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
		this.login = login;
		this.email = email;
	}
	public Cliente(String nome, String senha, String login,  String email) {
		this.nome = nome;
		this.senha = senha;
		this.login = login;
		this.email = email;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Cliente [idUsuario=" + idUsuario + ", nome=" + nome + ", senha=" + senha + ", login=" + login
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

}
