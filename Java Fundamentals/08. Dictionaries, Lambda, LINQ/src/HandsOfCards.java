import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> handsMap = new LinkedHashMap<>();
        String[] input = console.nextLine().split(": |, ");
        String name, card;

        while (!input[0].equals("JOKER")) {
            name = input[0];
            handsMap.putIfAbsent(name, new HashSet<>());
            for (int i = 1; i < input.length; i++) {
                card = input[i];
                if (!handsMap.get(name).contains(card)) {
                    handsMap.get(name).add(card);
                }
            }

            input = console.nextLine().split(": |, ");
        }

        for (Map.Entry<String, HashSet<String>> entry : handsMap.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), result(handsMap, entry.getKey()));
        }
    }


    static int result(LinkedHashMap<String, HashSet<String>> map, String name) {
        int totalValue = 0;

        HashSet<String> elements = map.get(name);

        for (String currentCard : elements) {
            int currentHandValue = 0;

            switch (currentCard.charAt(0)){
                case '1': currentHandValue = 10;
                    break;

                case '2': currentHandValue = 2;
                    break;

                case '3': currentHandValue = 3;
                    break;

                case '4': currentHandValue = 4;
                    break;

                case '5': currentHandValue = 5;
                    break;

                case '6': currentHandValue = 6;
                    break;

                case '7': currentHandValue = 7;
                    break;

                case '8': currentHandValue = 8;
                    break;

                case '9': currentHandValue = 9;
                    break;

                case 'J': currentHandValue = 11;
                    break;

                case 'Q': currentHandValue = 12;
                    break;

                case 'K': currentHandValue = 13;
                    break;

                case 'A': currentHandValue = 14;
                    break;
            }


            switch (currentCard.charAt(currentCard.length()-1)){
                case 'S': currentHandValue *= 4;
                    break;
                case 'H': currentHandValue *= 3;
                    break;
                case 'D': currentHandValue *= 2;
                    break;
                case 'C': currentHandValue *= 1;
                    break;
            }

            totalValue += currentHandValue;
        }

        return totalValue;
    }

}
