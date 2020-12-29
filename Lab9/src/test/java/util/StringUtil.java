package util;

import java.util.Random;

public class StringUtil {
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrtsuvwxyz";
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrtsuvwxyz1234567890";
    private static final Random random = new Random();

    public static String randomName(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }
        return sb.toString();
    }

    public static String randomString(int length){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static String randomEmail() {
        StringBuilder sb = new StringBuilder();
        sb.append(randomString(8))
                .append('@')
                .append(randomName(5))
                .append('.')
                .append(randomName(3));
        return sb.toString();
    }
}
