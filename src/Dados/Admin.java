package Dados;

public class Admin extends Person {
    private String password;

    public Admin(
            String name,
            String cpf,
            String email,
            String password
        ) {
        super(name, cpf, email);
        this.password = password;
    }
    public boolean comparePassword(String tryPassword) {
        return this.password.equals(tryPassword);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}

