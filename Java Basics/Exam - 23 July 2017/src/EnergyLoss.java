import java.util.Scanner;

/**
 * Created by Cammi on 23/07/2017.
 */
public class EnergyLoss {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int daysToTrain = Integer.parseInt(console.nextLine());
        int dancers = Integer.parseInt(console.nextLine());

        double energyWasted;
        double energyWastedTotal = 0;
        int hoursToTrain;

        for (int i=1; i<=daysToTrain; i++){
            hoursToTrain = Integer.parseInt(console.nextLine());
            if(i%2==0){
                if(hoursToTrain%2==0){
                    energyWasted = dancers*68;
                    energyWastedTotal += energyWasted;
                } else {
                    energyWasted = dancers*65;
                    energyWastedTotal += energyWasted;
                }
            } else {
                if(hoursToTrain%2==0){
                    energyWasted = dancers*49;
                    energyWastedTotal += energyWasted;
                } else {
                    energyWasted = dancers*30;
                    energyWastedTotal += energyWasted;
                }
            }
        }

        double energyFullTotal = 100*dancers*daysToTrain;
        double notWastedEnergyTotal = energyFullTotal-energyWastedTotal;
        double notWastedEnergyPerDancerPerDay = notWastedEnergyTotal/dancers/daysToTrain;

        double percent = energyWastedTotal/energyFullTotal*100;

        if(percent<=50){
            System.out.printf("They feel good! Energy left: %.2f",notWastedEnergyPerDancerPerDay);
        } else {
            System.out.printf("They are wasted! Energy left: %.2f", notWastedEnergyPerDancerPerDay);
        }
    }
}
