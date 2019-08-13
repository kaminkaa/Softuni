package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryMess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?<key>[^&?]+)=(?<value>[^&?]+)";
        Pattern pattern = Pattern.compile(regex);
        while (true) {
            String input = reader.readLine();
            if (input.equals("END")) {
                break;
            }
            LinkedHashMap<String, ArrayList<String>> queries = new LinkedHashMap<>();
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String key = matcher.group("key");
                String value = matcher.group("value");
                key = key.replaceAll("(%20|\\+)+", " ").trim();
                value = value.replaceAll("(%20|\\+)+", " ").trim();
                queries.putIfAbsent(key, new ArrayList<>());
                queries.get(key).add(value);
            }
            for (Map.Entry<String, ArrayList<String>> stringArrayListEntry : queries.entrySet()) {
                String values = String.join(", ", stringArrayListEntry.getValue());
                System.out.printf("%s=[%s]", stringArrayListEntry.getKey(), values);
            }
            System.out.println();
        }
    }
}