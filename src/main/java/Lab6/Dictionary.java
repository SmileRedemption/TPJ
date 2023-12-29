package Lab6;

import java.util.HashMap;
import java.util.Map;

class Dictionary {
    private final Map<String, String> ukraineEnglishWords = new HashMap<>();

    public void addWord(String eng, String ukr) {
        ukraineEnglishWords.put(eng, ukr);
    }

    public String translate(String ukr) {
        return ukraineEnglishWords.getOrDefault(ukr, "Error: unknown word!");
    }
}
