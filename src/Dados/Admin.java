package Dados;
import java.time.LocalDate;

public class Admin {
    private String id;
    private String name;
    private String cpf;
    private String email;
    private String password;

    public Admin(
            String id,
            String name,
            String cpf,
            String email,
            String password,
        ) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
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
    
    public boolean comparePassword(String tryPassword) {
        return this.password.equals(tryPassword);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setName(String name) {
        this.name = name;
    }
}

