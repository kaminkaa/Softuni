package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class ExtractSentencesByKeyword {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keyword = reader.readLine();
        String text = reader.readLine();
        String[] sentences = text.split("[.!?]\\s*");
        String regex = String.format("\\b%s\\b", keyword);
        Pattern pattern = Pattern.compile(regex);
        for (String sentence : sentences) {
            if (pattern.matcher(sentence).find()) {
                System.out.println(sentence);
            }
        }
    }
}
