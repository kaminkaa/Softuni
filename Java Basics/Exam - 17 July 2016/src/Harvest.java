import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Cammi on 22/07/2017.
 */
public class Harvest {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int vineyardArea = Integer.parseInt(console.nextLine());
        double grapeKgPerSqrM = Double.parseDouble(console.nextLine());
        int wineToBeSold = Integer.parseInt(console.nextLine());
        int workers = Integer.parseInt(console.nextLine());

        double areaForWine = vineyardArea*0.4;
        double grapeKg = areaForWine*grapeKgPerSqrM;
        double litersWine = grapeKg/2.5;

        if(litersWine>=wineToBeSold){
            double remainingWine = litersWine - wineToBeSold;
            double winePerWorker = remainingWine/workers;
            int wine = (int)litersWine;
            DecimalFormat df = new DecimalFormat("##.##");
            System.out.printf("Good harvest this year! Total wine: %d liters.", wine);
            System.out.println();
            System.out.printf("%s liters left -> %s liters per person.", df.format(Math.ceil(remainingWine)),df.format(Math.ceil(winePerWorker)));
        } else {
            double missingWine = wineToBeSold-litersWine;
            int missing = (int)missingWine;
            System.out.printf("It will be a tough winter! More %d liters wine needed.", missing);
        }
    }
}
