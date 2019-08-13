import java.util.Scanner;

public class PairsByDifference {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputNumbers = console.nextLine().split(" ");
        int difference = Integer.parseInt(console.nextLine());

        int[] numbers = new int[inputNumbers.length];

        for (int i=0; i<inputNumbers.length; i++){
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        int numberOfPairs = 0;
        int diff;

        for (int i = 0; i < numbers.length; i++){
            for (int j = i+1; j < numbers.length; j++){
                diff = Math.abs(numbers[i] - numbers[j]);
                if (diff == difference){
                    numberOfPairs ++;
                }
            }
        }

        System.out.println(numberOfPairs);
    }
}
