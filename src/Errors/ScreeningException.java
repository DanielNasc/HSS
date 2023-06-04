package Errors;

public class ScreeningException extends GenericAppException {
    public ScreeningException(String exam) {
        super("Infelizmente você não pode doar sangue por causa dos exames: " + exam, 400);
    }
}
