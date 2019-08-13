import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MagicExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        String word1 = input[0].toLowerCase();
        String word2 = input[1].toLowerCase();

        System.out.println(AreWordsMagicExchangeable(word1, word2));
    }

    static boolean AreWordsMagicExchangeable (String w1, String w2){
        boolean result = true;

       /* LinkedHashMap<Character,Character> charsMap = new LinkedHashMap<>();

        if (w1.length() == w2.length()) {
            for (int i = 0; i < w1.length(); i++) {
                if (!charsMap.containsValue(w2.charAt(i))) {
                    charsMap.putIfAbsent(w1.charAt(i), w2.charAt(i));
                }
            }

            for (int i = 0; i < w2.length(); i++) {
                if (!charsMap.containsValue(w2.charAt(i))) {
                    result = false;
                    break;
                }
            }
        } else { */
            if (countUniqueCharacters(w1) == countUniqueCharacters(w2)){
                result = true;
            } else {
                result = false;
            }
       // }
        return result;
    }

    static int countUniqueCharacters (String word) {
        int charCount = 0;
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (!chars.contains(word.charAt(i))) {
                chars.add(word.charAt(i));
                charCount++;
            }
        }
        return charCount;
    }
}
