package br.com.devti.gestaotransportadora.entity;

public class ClienteEntity {

    private String email;
    private String name;
    private String birthday;
    private String cpf;
    private Integer id;
    
    
    
    public ClienteEntity(Integer id, String name, String birthday, String cpf, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.cpf = cpf;
        this.email = email;
        
    }
    

    public ClienteEntity() {
        
    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
