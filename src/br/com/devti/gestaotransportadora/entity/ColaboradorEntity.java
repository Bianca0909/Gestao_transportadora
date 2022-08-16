package br.com.devti.gestaotransportadora.entity;

public class ColaboradorEntity {

    private String pis;
    private String name;
    private String cpf;
    private String birthday;
    private int id;

    public ColaboradorEntity(int id, String name, String birthday, String cpf, String pis) {
        this.name = name;
        this.pis = pis;
        this.cpf = cpf;
        this.birthday = birthday;
        this.id = id;

    }

    public ColaboradorEntity() {
       
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
