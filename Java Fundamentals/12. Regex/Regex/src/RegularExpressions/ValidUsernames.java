package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> matches = new ArrayList<>();
        String input = reader.readLine();
        String regex = "\\b[a-zA-Z][a-zA-Z0-9_]{2,24}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            matches.add(matcher.group(0));
        }
        int maxLength = 0;
        int index = -1;
        for (int i = 0; i < matches.size() - 1; i++) {
            int length = matches.get(i).length() + matches.get(i + 1).length();
            if (length > maxLength) {
                maxLength = length;
                index = i;
            }
        }
        System.out.println(matches.get(index));
        System.out.println(matches.get(index + 1));
    }
}