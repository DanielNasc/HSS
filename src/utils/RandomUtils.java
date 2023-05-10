package utils;

public class RandomUtils {
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = upper.toLowerCase();
    public static final String digits = "0123456789";
    public static final String alphanum = upper + lower + digits;

    public static String generateId(int length) {
        String buffer = "";

        for (int i = 0; i < length; i++) {
            buffer += alphanum.charAt((int) (Math.random() * alphanum.length()));
        }

        return buffer;
    }
}
