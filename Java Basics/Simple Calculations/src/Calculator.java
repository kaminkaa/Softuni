import java.util.Scanner;

/**
 * Created by Cammi on 18/07/2017.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double amount = Double.parseDouble(console.nextLine());
        String inputCurrency = console.nextLine();
        String outputCurrency = console.nextLine();

        double USDrate = 1.79549;
        double EURrate = 1.95583;
        double GBPrate = 2.53405;

        double amountToBGN;

        switch (inputCurrency) {
            case "BGN": amountToBGN = amount;
                break;
            case "USD": amountToBGN = amount*USDrate;
                break;
            case "EUR": amountToBGN = amount*EURrate;
                break;
            case "GBP": amountToBGN = amount*GBPrate;
                break;
            default: amountToBGN = 0.00;
                break;
        }

        double resultAmount;

        switch (outputCurrency) {
            case "BGN": resultAmount = amountToBGN;
                break;
            case "USD": resultAmount = amountToBGN/USDrate;
                break;
            case "EUR": resultAmount = amountToBGN/EURrate;
                break;
            case "GBP": resultAmount = amountToBGN/GBPrate;
                break;
            default: resultAmount = 0.00;
                break;
        }

        System.out.printf("%.2f %s",resultAmount, outputCurrency);
    }
}
