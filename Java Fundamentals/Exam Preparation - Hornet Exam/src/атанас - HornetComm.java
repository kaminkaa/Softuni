import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetComm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pattern messagePattern = Pattern.compile("^(?<code>[0-9]+) <-> (?<message>[a-zA-Z0-9]+)$");
        Pattern broadcastPattern = Pattern.compile("^(?<message>[^0-9]+) <-> (?<frequency>[a-zA-Z0-9]+)$");
        ArrayList<String> privateMessages = new ArrayList<>();
        ArrayList<String> broadcasts = new ArrayList<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Hornet is Green")) {
                break;
            }
            Matcher messageMatcher = messagePattern.matcher(input);
            Matcher broadcastMatcher = broadcastPattern.matcher(input);

            while (messageMatcher.find()) {
                StringBuilder sb = new StringBuilder();
                sb.append(messageMatcher.group("code"));
                sb.reverse();
                privateMessages.add(sb.toString() + " -> " + messageMatcher.group("message"));
            }
            while (broadcastMatcher.find()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < broadcastMatcher.group("frequency").length(); i++) {
                    char currentChar = broadcastMatcher.group("frequency").charAt(i);
                    if (currentChar > 64 && currentChar < 91) {
                        currentChar += 32;
                    } else if (currentChar > 96 && currentChar < 123) {
                        currentChar -= 32;
                    }
                    sb.append(currentChar);
                }
                broadcasts.add(sb.toString() + " -> " + broadcastMatcher.group("message"));
            }
        }
        System.out.println("Broadcasts:");
        int count = 0;
        for (String broadcast : broadcasts) {
            System.out.println(broadcast);
            count++;
        }
        if (count == 0) {
            System.out.println("None");
        }
        count = 0;
        System.out.println("Messages:");
        for (String privateMessage : privateMessages) {
            System.out.println(privateMessage);
            count++;
        }
        if (count == 0) {
            System.out.println("None");
        }
    }
}