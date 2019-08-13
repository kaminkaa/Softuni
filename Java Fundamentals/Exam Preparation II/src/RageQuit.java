import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Character> uniqueSymbols = new ArrayList<>();
        String input = reader.readLine();
        String regex = "((?<text>[^\\d]+?)(?<count>\\d+))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            String message = matcher.group("text").toUpperCase();
            int count = Integer.parseInt(matcher.group("count"));
            if (count == 0) {
                continue;
            }
            for (int i = 0; i < message.length(); i++) {
                uniqueSymbols.add(message.toUpperCase().charAt(i));
            }
            for (int i = 0; i < count; i++) {
                sb.append(message);
            }
        }
        System.out.printf("Unique symbols used: %d%n", uniqueSymbols.stream().distinct().count());
        System.out.println(sb);
    }
}