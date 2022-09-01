package br.com.devti.gestaotransportadora.entity;

public class OrdemServicoEntity {

	private Integer id;
	private String endereco;
	private Integer clienteId;
	private Integer fornecedorId;
	private Integer colaboradorId;
	private Double valor;
	private String situacao;
	private Double valorPago;
	private Double valorRestante;
    private Double troco;
	
	public OrdemServicoEntity(Integer id, String endereco, Integer clienteId, Integer fornecedorId,
			Integer colaboradorId, Double valor, String situacao, Double valorPago, Double valorRestante) {
		this.id = id;
		this.endereco = endereco;
		this.clienteId = clienteId;
		this.fornecedorId = fornecedorId;
		this.colaboradorId = colaboradorId;
		this.valor = valor;
		this.situacao = situacao;
		this.valorPago = valorPago;
		this.valorRestante = valorRestante;
	}

	public OrdemServicoEntity() {

	}

	public Double getTroco() {
		return troco;
	}

	public void setTroco(Double troco) {
		this.troco = troco;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Double getValorRestante() {
		return valorRestante;
	}

	public void setValorRestante(Double valorRestante) {
		this.valorRestante = valorRestante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Integer fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public Integer getColaboradorId() {
		return colaboradorId;
	}

	public void setColaboradorId(Integer colaboradorId) {
		this.colaboradorId = colaboradorId;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
