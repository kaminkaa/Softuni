import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchForANumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> inputNumbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        List<Integer> tokens = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int elementsToTake = tokens.get(0);
        int elementsToDelete = tokens.get(1);
        int numberToFind = tokens.get(2);

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < elementsToTake; i++) {
            numbers.add(inputNumbers.get(i));
        }

        for (int i = 0; i < elementsToDelete; i++) {
            numbers.remove(0);
        }

        boolean isFound = false;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == numberToFind){
                isFound = true;
                break;
            }
        }

        if (isFound)
            System.out.printf("YES!");
        else
            System.out.printf("NO!");

    }
}
