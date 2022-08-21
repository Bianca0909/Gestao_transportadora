package br.com.devti.gestaotransportadora.entity;

public class FornecedorEntity {

	private String cnpj;
	private String name;
	private String birthday;
	private Integer id;

	public FornecedorEntity(Integer id, String cnpj, String name, String birthday) {
		this.cnpj = cnpj;
		this.name = name;
		this.birthday = birthday;
		this.id = id;
	}

	public FornecedorEntity() {

	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
