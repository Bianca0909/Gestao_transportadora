/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.devti.gestaotransportadora.entity;

/**
 *
 * @author usuario
 */
public class FornecedorEntity {

    private String cnpj;
    private String name;
    private String birthday;
    private Long id;

    public FornecedorEntity(Long id, String cnpj, String name, String birthday) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
