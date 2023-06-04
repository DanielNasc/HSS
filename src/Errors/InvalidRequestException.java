package Errors;

public class InvalidRequestException extends Exception {
    public InvalidRequestException(String correctFormat) {
        super("Formato de requisição inválido!\nO esperado é: " + correctFormat);
    }
}
