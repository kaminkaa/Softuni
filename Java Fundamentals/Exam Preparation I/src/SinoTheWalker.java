import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class SinoTheWalker {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] time = Arrays.stream(reader.readLine().split(":"))
                .mapToInt(Integer::valueOf)
                .toArray();
        int numberOfSteps = Integer.parseInt(reader.readLine());
        int secondsPerStep = Integer.parseInt(reader.readLine());

        BigInteger totalSeconds = BigInteger.valueOf(time[0]*3600 + time[1]*60 + time[2]).add(BigInteger.valueOf(numberOfSteps).multiply(BigInteger.valueOf(secondsPerStep)));

        int hoursArrive = totalSeconds.divide(BigInteger.valueOf(3600)).remainder(BigInteger.valueOf(24)).intValue();
        totalSeconds = totalSeconds.remainder(BigInteger.valueOf(3600));
        int minutesArrive = totalSeconds.divide(BigInteger.valueOf(60)).intValue();
        totalSeconds = totalSeconds.remainder(BigInteger.valueOf(60));
        int secondsArrive = totalSeconds.intValue();

        System.out.printf("Time Arrival: %02d:%02d:%02d", hoursArrive, minutesArrive, secondsArrive);
    }

    static void PrintArrivalTime (int hoursArrive, int minutesArrive, int secondsArrive) {
        System.out.printf("Time Arrival: ");
        if (hoursArrive>=0 && hoursArrive <10) {
            System.out.printf("0%d:",hoursArrive);
        } else {
            System.out.printf("%d:",hoursArrive);
        }
        if (minutesArrive>=0 && minutesArrive <10) {
            System.out.printf("0%d:",minutesArrive);
        } else {
            System.out.printf("%d:",minutesArrive);
        }
        if (secondsArrive>=0 && secondsArrive <10) {
            System.out.printf("0%d",secondsArrive);
        } else {
            System.out.printf("%d",secondsArrive);
        }
    }
}
