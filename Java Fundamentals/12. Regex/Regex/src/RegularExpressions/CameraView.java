package RegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CameraView {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] elements = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::valueOf).toArray();
        int skipCount = elements[0];
        int takeCount = elements[1];
        String text = reader.readLine();
        String regex = String.format("\\|<\\w{%d}(?<output>(\\w){1,%d})", skipCount, takeCount);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> views = new ArrayList<>();

        while (matcher.find()) {
        String view = matcher.group("output");
        views.add(view);
        }
        System.out.println(String.join(", ",views));
    }
}
