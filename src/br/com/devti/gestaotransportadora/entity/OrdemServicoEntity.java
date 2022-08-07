package br.com.devti.gestaotransportadora.entity;

public class OrdemServicoEntity {

    private Long id;
    private String endereço;
    private Long clienteId;
    private Long fornecedorId;
    private Long colaboradorId;
    private Double valor;

    public OrdemServicoEntity(Long id, String endereço, Long clienteId, Long fornecedorId, Long colaboradorId, Double valor) {
        this.id = id;
        this.endereço = endereço;
        this.clienteId = clienteId;
        this.fornecedorId = fornecedorId;
        this.colaboradorId = colaboradorId;
        this.valor = valor;
    }

    public OrdemServicoEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Long fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public Long getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Long colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
