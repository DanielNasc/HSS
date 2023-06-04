package Errors;

public class NotFoundDataException extends Exception {
    String repository;
    int status = 404;

    public NotFoundDataException(String repository, String message) {
        super("Não foi possível encontrar os dados no repositório " + repository + "!\n" + message);
        this.repository = repository;
    }

    public String getRepository() {
        return this.repository;
    }

    public int getStatus() {
        return this.status;
    }
}
