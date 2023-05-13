package App;

public class ResponseClass {
    private int status;
    private String message;
    private String token = null;

    public ResponseClass(
        int status,
        String message,
        String defToken
    ) {
        this.status = status;
        this.message = message;
        this.token = defToken;
    }

    public int getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
