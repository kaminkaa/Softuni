package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UseYourChainsBuddy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String regex = "<p>(.+?)</p>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String output = "";
        while (matcher.find()) {
            String match = matcher.group(1);
            match = match.replaceAll("[^a-z0-9]", " ");
            StringBuilder sb = new StringBuilder(match);
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) > 96 && sb.charAt(i) < 110) {
                    char replacement = (char)(sb.charAt(i) + 13);
                    sb.replace(i, i+1, Character.toString(replacement));
                }else if (sb.charAt(i) > 109 && sb.charAt(i) < 123){
                    char replacement = (char)(sb.charAt(i) - 13);
                    sb.replace(i, i+1, Character.toString(replacement));
                }
            }
            output += sb.toString();
        }
        output = output.replaceAll("\\s+", " ");
        System.out.println(output);
    }
}