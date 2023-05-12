package Model.Entities;

import Utils.RandomUtils;

public abstract class Person {
    private String id;
    private String name;
    private String cpf;
    private String email;
    
    public Person(
            String name,
            String cpf,
            String email
        ) {
        this.id = RandomUtils.generateId(12);
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
