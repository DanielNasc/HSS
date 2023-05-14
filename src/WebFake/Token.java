package WebFake;

public class Token {
    public static String CreateToken(String type, String id) {
        return type + "." + id;
    }

    public static String[] BreakToken(String token) {
        if (token == null) return null;

        return token.split("\\.");
    }

    public static String GetType(String token) {
        return BreakToken(token)[0];
    }
}
