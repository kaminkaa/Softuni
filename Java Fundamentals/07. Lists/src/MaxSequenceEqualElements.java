import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSequenceEqualElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                                .map(Integer::valueOf)
                                .collect(Collectors.toList());

        int countSequence = 1;
        int longestSequence = 0;
        int sequenceValue = numbers.get(0);

        int reminder = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (reminder == numbers.get(i)){
                countSequence++;
                if (countSequence > longestSequence){
                    longestSequence = countSequence;
                    sequenceValue = numbers.get(i);
                }
            } else {
                countSequence = 1;
            }
            reminder = numbers.get(i);
        }

        if (longestSequence != 0) {
            for (int i = 0; i < longestSequence; i++) {
                System.out.print(sequenceValue + " ");
            }
        } else {
            System.out.println(sequenceValue);
        }
    }
}
