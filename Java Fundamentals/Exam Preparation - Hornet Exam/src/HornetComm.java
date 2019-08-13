import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetComm {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        List<String> privateMessages = new ArrayList<>();
        List<String> broadcasts = new ArrayList<>();
        StringBuilder collectionEntry = new StringBuilder();

        String privateMessageRegex = "^([0-9]+)$";
        Pattern privateMessagePattern = Pattern.compile(privateMessageRegex);
        Matcher privateMessageMatcher;
        String broadcastRegex = "^([^0-9]+)$";
        Pattern broadcastPattern = Pattern.compile(broadcastRegex);
        Matcher broadcastMatcher;
        String messageRegex = "^([a-zA-Z0-9]+)$";
        Pattern messagePattern = Pattern.compile(messageRegex);
        Matcher messageMatcher;

        while (true){
            if (input.equals("Hornet is Green")) { break; }

            String[] tokens = input.split(" <-> ");
            StringBuilder firstQuery = new StringBuilder(tokens[0]);
            StringBuilder secondQuery = new StringBuilder(tokens[1]);

            privateMessageMatcher = privateMessagePattern.matcher(firstQuery.toString());
            broadcastMatcher = broadcastPattern.matcher(firstQuery.toString());
            messageMatcher = messagePattern.matcher(secondQuery.toString());

            collectionEntry.delete(0,collectionEntry.length());

            if (broadcastMatcher.find() && messageMatcher.find()) {
                secondQuery = ConvertLetters(secondQuery);
                collectionEntry.append(secondQuery).append(" -> ").append(firstQuery);
                broadcasts.add(collectionEntry.toString());
            }

            if (privateMessageMatcher.find() && messageMatcher.find()) {
                firstQuery.reverse();
                collectionEntry.append(firstQuery).append(" -> ").append(secondQuery);
                privateMessages.add(collectionEntry.toString());
            }

            input = reader.readLine();
        }

        PrintBroadcastAndMessages(broadcasts,privateMessages);
    }

    static void PrintBroadcastAndMessages (List<String> broadcasts, List<String> pmessages) {
        if (broadcasts.isEmpty() && pmessages.isEmpty()) {
            System.out.println("None");
            return;
        }

        System.out.printf("Broadcasts:\n");
        if (!broadcasts.isEmpty()) {
            for (String broadcast : broadcasts) {
                System.out.println(broadcast);
            }
        } else {
            System.out.println("None");
        }

        System.out.printf("Messages:\n");
        if (!pmessages.isEmpty()) {
            for (String pmessage : pmessages) {
                System.out.println(pmessage);
            }
        } else {
            System.out.println("None");
        }
    }

    static StringBuilder ConvertLetters (StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isLowerCase(c)) {
                sb.setCharAt(i, Character.toUpperCase(c));
            } else {
                sb.setCharAt(i, Character.toLowerCase(c));
            }
        }
        return sb;
    }
}
