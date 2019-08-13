import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnduranceRally {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split("\\s+");
        double[] zones = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double :: valueOf)
                .toArray();
        List<Integer> checkpointIndexes = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer :: valueOf)
                .collect(Collectors.toList());


        for (int i = 0; i < names.length; i++) {
            CheckIfADriverFinishes(names[i], zones, checkpointIndexes);
        }
    }

    static void CheckIfADriverFinishes (String name, double[] zones, List<Integer> checkpoints) {
        double fuel;
        fuel = (double)name.charAt(0);

        for (int i = 0; i < zones.length; i++) {
            if (checkpoints.contains(i)) {
                fuel += zones[i];
            } else {
                fuel -= zones[i];
                if (fuel < 0) {
                    System.out.printf("%s - reached %d\n", name, i);
                    return;
                }
            }
        }

        System.out.printf("%s - fuel left %.2f\n", name, fuel);
    }
}
