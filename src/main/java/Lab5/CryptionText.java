package Lab5;

public class CryptionText {
    public static String encryption(String string, String keyWord) {
        StringBuilder newString = new StringBuilder();
        char[] keyWordChars = keyWord.toCharArray();
        int key = getKey(keyWordChars);

        for (int i = 0; i < string.length(); i++) {
            int c = (string.charAt(i) + key);
            newString.append((char) c);
        }

        return newString.toString();
    }

    private static int getKey(char[] charArray) {
        int key = 0;

        for (char value : charArray)
            key += value;
        return key;
    }

    public static String decryption(String str, String keyWord) {
        StringBuilder newString = new StringBuilder();
        char[] keyWordChars = keyWord.toCharArray();
        int key = getKey(keyWordChars);

        for (int i = 0; i < str.length(); i++) {
            int c = (str.charAt(i) - key);
            newString.append((char) c);
        }

        return newString.toString();
    }
}
