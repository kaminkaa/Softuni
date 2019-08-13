import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tickets = reader.readLine().split(",");

        for (int i = 0; i < tickets.length; i++) {

            tickets[i] = tickets[i].replaceAll("\\s+","");

            if (tickets[i].length() == 20) {
                if (CheckForJackpot(tickets[i])) {
                    System.out.printf("ticket \"%s\" - 10%c Jackpot!\n", tickets[i], tickets[i].charAt(0));
                    continue;
                }

                CheckTicket(tickets[i]);
            } else {
                System.out.printf("invalid ticket\n");
            }
        }


    }

    static boolean CheckForJackpot (String ticket) {
        char[] elements = ticket.toCharArray();
        HashSet<Character> jackpotChar = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            jackpotChar.add(elements[i]);
        }

        if (jackpotChar.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    static void CheckTicket (String ticket) {
        String symbol1Regex = "@{6,}";
        Pattern symbol1Pattern = Pattern.compile(symbol1Regex);
        String symbol2Regex = "#{6,}";
        Pattern symbol2Pattern = Pattern.compile(symbol2Regex);
        String symbol3Regex = "\\${6,}";
        Pattern symbol3Pattern = Pattern.compile(symbol3Regex);
        String symbol4Regex = "\\^{6,}";
        Pattern symbol4Pattern = Pattern.compile(symbol4Regex);


        String left = ticket.substring(0,10);
        String right = ticket.substring(10,20);
        Character winningSymbol = ' ';
        int winningLength = -1;
        boolean ticketIsWinning = false;

        Matcher s1LeftMatch = symbol1Pattern.matcher(left);
        Matcher s1RightMatch = symbol1Pattern.matcher(right);
        if (s1LeftMatch.find() && s1RightMatch.find()) {
            winningSymbol = '@';
            winningLength = Math.min(s1LeftMatch.group().length(), s1RightMatch.group().length());
            ticketIsWinning = true;
        }
        Matcher s2LeftMatch = symbol2Pattern.matcher(left);
        Matcher s2RightMatch = symbol2Pattern.matcher(right);
        if (s2LeftMatch.find() && s2RightMatch.find()) {
            winningSymbol = '#';
            winningLength = Math.min(s2LeftMatch.group().length(), s2RightMatch.group().length());
            ticketIsWinning = true;
        }
        Matcher s3LeftMatch = symbol3Pattern.matcher(left);
        Matcher s3RightMatch = symbol3Pattern.matcher(right);
        if (s3LeftMatch.find() && s3RightMatch.find()) {
            winningSymbol = '$';
            winningLength = Math.min(s3LeftMatch.group().length(), s3RightMatch.group().length());
            ticketIsWinning = true;
        }
        Matcher s4LeftMatch = symbol4Pattern.matcher(left);
        Matcher s4RightMatch = symbol4Pattern.matcher(right);
        if (s4LeftMatch.find() && s4RightMatch.find()) {
            winningSymbol = '^';
            winningLength = Math.min(s4LeftMatch.group().length(), s4RightMatch.group().length());
            ticketIsWinning = true;
        }

        if (ticketIsWinning) {
            System.out.printf("ticket \"%s\" - %d%c\n", ticket, winningLength, winningSymbol);
        } else {
            System.out.printf("ticket \"%s\" - no match\n", ticket);
        }

    }
}
