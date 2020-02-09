package br.com.lojaonline.entidade.enums;

public enum EPerfil {

	NENHUM(0,"Nenhum"),ADM(1,"Administrador"), CLIENTE(2,"Cliente");
	
	private int code;
	private String descricao;
	
	private EPerfil(int code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}
	
	public EPerfil fromCode(int code) {
		for(EPerfil e : EPerfil.values()) {
			if(e.getCode() == code) {
				return e;
			}
		}
		return null;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
