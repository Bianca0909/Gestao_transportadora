package br.com.devti.gestaotransportadora.entity;

public class OrdemServicoEntity {

    private Long id;
    private String endereço;
    private ClienteEntity cliente;
    private FornecedorEntity fornecedor;
    private ColaboradorEntity colaborador;
    private Double valor;
    private String veiculo;
    

    public OrdemServicoEntity(Long id, String endereço, ClienteEntity cliente, FornecedorEntity fornecedor, ColaboradorEntity colaborador, Double valor, String veiculo) {
        this.id = id;
        this.endereço = endereço;
        this.cliente = cliente;
        this.fornecedor = fornecedor;
        this.colaborador = colaborador;
        this.valor = valor;
        this.veiculo = veiculo;
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

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public FornecedorEntity getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorEntity fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ColaboradorEntity getColaborador() {
        return colaborador;
    }

    public void setColaborador(ColaboradorEntity colaborador) {
        this.colaborador = colaborador;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

}
