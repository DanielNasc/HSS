package Errors;

public class NotFoundDataException extends Exception {
    String repository;

    public NotFoundDataException(String repository, String message) {
        super("Não foi possível encontrar os dados no repositório " + repository + "!\n" + message);
        this.repository = repository;
    }

    public String getRepository() {
        return this.repository;
    }
}
