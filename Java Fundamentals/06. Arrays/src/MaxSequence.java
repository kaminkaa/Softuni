import java.util.Scanner;

public class MaxSequence {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputNumbers = console.nextLine().split(" ");
        int[] numbers = new int[inputNumbers.length];

        for (int i=0; i<inputNumbers.length; i++){
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        int longestSequence = 0;
        int sequenceValue;

        int reminder = numbers[0];
        sequenceValue = numbers [0];
        int sequence = 1;

        for (int i=1; i <= numbers.length-1; i++){
            if (reminder == numbers[i]) {
                sequence++;
                if (sequence > longestSequence) {
                    longestSequence = sequence;
                    sequenceValue = numbers[i];
                }
            } else {
                    sequence = 1;
            }
            reminder = numbers[i];
        }

        for (int i=0; i < longestSequence; i++){
            System.out.printf("%d ", sequenceValue);
        }
    }
}
