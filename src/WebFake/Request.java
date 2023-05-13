package WebFake;

public class Request {
    private String[] payload;
    private String token;

    public Request(String[] payload, String token) {
        this.payload = payload;
        this.token = token;
    }

    public String[] getPayload() {
        return payload;
    }

    public String getToken() {
        return token;
    }
}
