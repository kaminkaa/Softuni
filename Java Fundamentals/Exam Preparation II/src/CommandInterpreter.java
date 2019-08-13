import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class CommandInterpreter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> inputList = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        loop:
        while (true) {
            String[] tokens = reader.readLine().split("\\s+");
            switch (tokens[0]) {
                case "end":
                    break loop;
                case "sort":
                    sortList(inputList, Integer.parseInt(tokens[2]), Integer.parseInt(tokens[4]));
                    break;
                case "reverse":
                    reverseList(inputList, Integer.parseInt(tokens[2]), Integer.parseInt(tokens[4]));
                    break;
                case "rollLeft":
                    if (Integer.parseInt(tokens[1]) < 0){
                        System.out.println("Invalid input parameters.");
                        continue;
                    }
                    Collections.rotate(inputList, Integer.parseInt(tokens[1]) * -1);
                    break;
                case "rollRight":
                    if (Integer.parseInt(tokens[1]) < 0){
                        System.out.println("Invalid input parameters.");
                        continue;
                    }
                    Collections.rotate(inputList, Integer.parseInt(tokens[1]));
                    break;
            }
        }
        System.out.println(inputList);
    }

    private static void sortList(ArrayList<String> list, int startIndex, int count) {
        if (startIndex < 0 || startIndex >= list.size()|| startIndex + count > list.size() || count < 0) {
            System.out.println("Invalid input parameters.");
            return;
        }
        Collator col = Collator.getInstance();
        ArrayList<String> subList = new ArrayList<String>(list.subList(startIndex, startIndex+ count)
                .stream().sorted(col::compare).collect(Collectors.toCollection(ArrayList::new)));

        for (int i = 0; i < count; i++) {
            list.set(startIndex + i, subList.get(i));
        }
    }

    private static void reverseList(ArrayList<String> list, int startIndex, int count) {
        if (startIndex < 0 || startIndex >= list.size()|| startIndex + count > list.size() || count < 0) {
            System.out.println("Invalid input parameters.");
            return;
        }
        for (int i = 0; i < count / 2; i++) {
            String temp = list.get(startIndex + count - i - 1);
            list.set(startIndex + count - i - 1, list.get(startIndex + i));
            list.set(startIndex + i, temp);
        }
    }
}