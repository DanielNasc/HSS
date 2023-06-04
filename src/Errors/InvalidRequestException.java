package Errors;

public class InvalidRequestException extends GenericAppException {
    public InvalidRequestException(String correctFormat) {
        super("Formato de requisição inválido!\nO esperado é: " + correctFormat, 400);
    }
}
