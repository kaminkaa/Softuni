import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexmon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String didimonRegex = "([^a-zA-Z-]+)";
        String bojomonRegex = "([a-zA-Z]+-[a-zA-Z]+)";
        Pattern didiPattern = Pattern.compile(didimonRegex);
        Pattern bojoPattern = Pattern.compile(bojomonRegex);

        while (!input.isEmpty()) {
            Matcher didiMatcher = didiPattern.matcher(input);
            if (didiMatcher.find()) {
                String match = didiMatcher.group(0);
                System.out.println(match);
                input = input.substring(input.indexOf(match) + match.length(), input.length());
               //System.out.println(input);
            } else {
                break;
            }
            Matcher bojoMatcher = bojoPattern.matcher(input);
            if (bojoMatcher.find()) {
                String match = bojoMatcher.group(0);
                System.out.println(match);
                input = input.substring(input.indexOf(match) + match.length(), input.length());
                //System.out.println(input);
            } else {
                break;
            }
        }

    }
}
