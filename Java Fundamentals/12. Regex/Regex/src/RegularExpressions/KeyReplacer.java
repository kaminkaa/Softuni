package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyReplacer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("[|<\\\\]");
        String start = tokens[0];
        String end = tokens[tokens.length-1];
        String regex = String.format("%s(?<message>.*?)%s", start, end);
        String text = reader.readLine();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group("message"));
        }
        System.out.println(sb.length() > 0 ? sb.toString() : "Empty result");
    }
}
