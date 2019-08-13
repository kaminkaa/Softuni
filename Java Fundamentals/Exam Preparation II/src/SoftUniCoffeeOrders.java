import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SoftUniCoffeeOrders {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        BigDecimal totalSum = new BigDecimal(0);
        DecimalFormat df = new DecimalFormat("#.00");
        for (int i = 0; i < n; i++) {
            BigDecimal pricePerCapsule = new BigDecimal(reader.readLine());
            LocalDate date = LocalDate.parse(reader.readLine(), dtf);
            int capsulesCount = Integer.parseInt(reader.readLine());
            int daysInMonth = getDaysOfMonth(date);
            BigDecimal currentOrderTotal = BigDecimal.valueOf(daysInMonth)
                    .multiply(BigDecimal.valueOf(capsulesCount)).multiply(pricePerCapsule);
            System.out.printf("The price for the coffee is: $%s%n", df.format(currentOrderTotal));
            totalSum = totalSum.add(currentOrderTotal);
        }
        System.out.printf("Total: $%s", df.format(totalSum));
    }

    private static int getDaysOfMonth(LocalDate date) {
        if (date.getYear() % 4 == 0){
            return date.getMonth().maxLength();
        }else{
            return date.getMonth().minLength();
        }
    }
}