import java.util.Scanner;

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputNumbers = console.nextLine().split(" ");
        int[] numbers = new int[inputNumbers.length];

        for (int i=0; i<inputNumbers.length; i++){
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }
        int countOccurencies = 1;
        int maxOccurencies = 0;
        int mostFrequentNumber = numbers[0];

        for (int j=0; j < numbers.length; j++){
            countOccurencies = 0;
            for (int i=0; i < numbers.length; i++){
                if (numbers[i] == numbers[j]){
                    countOccurencies++;
                }
            }
            if (countOccurencies > maxOccurencies){
                maxOccurencies = countOccurencies;
                mostFrequentNumber = numbers[j];
            }
        }

        System.out.println(mostFrequentNumber);
    }
}
