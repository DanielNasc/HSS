package WebFake;

public class Response {
    private int status;
    private String message;
    private String token = null;
    private Object data;

    public Response(
        int status,
        String message,
        String defToken,
        Object data
    ) {
        this.status = status;
        this.message = message;
        this.token = defToken;
        this.data = data;
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

    public Object getData() {
        return data;
    }
}
