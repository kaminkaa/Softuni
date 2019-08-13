import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumReversedNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // take each number:
        String[] inputNumbers = reader.readLine().split("\\s+");
        // reverse each number's digits and keep it in an array of strings:
        String[] inputNumbersReversedDigits = Arrays.stream(inputNumbers)
                .map(text -> new StringBuilder(text).reverse().toString())
                .toArray(String[]::new);
        // convert the array of strings to array of ints:
        int[] numbers = Arrays.stream(inputNumbersReversedDigits)
                .mapToInt(number -> Integer.parseInt(number))
                .toArray();
        int sum = Arrays.stream(numbers).sum();

        System.out.println(sum);
    }
}
