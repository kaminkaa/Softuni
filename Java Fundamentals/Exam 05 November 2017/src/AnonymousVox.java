import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnonymousVox {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputLine = new StringBuilder(reader.readLine());
        String valuesLine = reader.readLine();

        String placeholderRegex = "(?<start>[a-zA-Z]+)(?<placeholder>[^&?]+)(?<end>\\1)";
        String valuesRegex = "(\\{(?<value>[^{}&?]+)\\})";

        Pattern placeholderPattern = Pattern.compile(placeholderRegex);
        Pattern valuesPattern = Pattern.compile(valuesRegex);

        Matcher placeholderMatcher = placeholderPattern.matcher(inputLine.toString());
        Matcher valuesMatcher = valuesPattern.matcher(valuesLine);

        List<String> values = new ArrayList<>();
        while (valuesMatcher.find()) {
            values.add(valuesMatcher.group("value"));
        }

        List<String> placeholders = new ArrayList<>();
        while (placeholderMatcher.find()) {
            placeholders.add(placeholderMatcher.group("placeholder"));
        }

        int i =0;

        while (i < placeholders.size()) {
            int startIndexPlaceholder = inputLine.indexOf(placeholders.get(i));
            int endIndexPlaceholder = startIndexPlaceholder + placeholders.get(i).length();
            inputLine.replace(startIndexPlaceholder,endIndexPlaceholder,values.get(i));
            i++;
        }

        System.out.println(inputLine.toString());
    }
}
