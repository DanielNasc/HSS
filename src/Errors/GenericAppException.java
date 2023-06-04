package Errors;

public abstract class GenericAppException extends Exception {
    private String message;
    private int status;

    public GenericAppException(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }
}
