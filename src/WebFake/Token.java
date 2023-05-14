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
        String[] s = BreakToken(token);
        if (s == null || s.length < 1) return null;
        return s[0];
    }

    public static String GetID(String token) {
        String[] s = BreakToken(token);
        if (s == null || s.length < 2) return null;
        return s[1];
    }
}