import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexmon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        Pattern bojoPat = Pattern.compile("[a-zA-Z]+-[a-zA-Z]+");
        Pattern didiPat = Pattern.compile("[^a-zA-Z\\-]+");

        Matcher bojoMatch = bojoPat.matcher(str);
        Matcher didiMatch = didiPat.matcher(str);

        int bojoIndex = 0;
        int didiIndex = 0;

        while (true) {
            boolean hasDMatch = false;
            boolean hasBMatch = false;

            if (hasDMatch = didiMatch.find(didiIndex)) {
                bojoIndex = didiMatch.end();
                System.out.println(didiMatch.group());
            }
            if (!hasDMatch) break;

            if (hasBMatch = bojoMatch.find(bojoIndex)) {
                didiIndex = bojoMatch.end();
                System.out.println(bojoMatch.group());
            }

            if (!hasBMatch) break;
        }
    }
}