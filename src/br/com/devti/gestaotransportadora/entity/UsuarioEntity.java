package br.com.devti.gestaotransportadora.entity;

public class UsuarioEntity {
	private Long id;
	private String login;
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioEntity(String login, String senha, Long id) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}

	public UsuarioEntity() {
		
	}
	public UsuarioEntity(Long id, String login) {
		this.id = id;
		this.login = login;
		// TODO Auto-generated constructor stub
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


}
