import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HornetAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Long> beehives = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        List<Long> hornets = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Long::valueOf)
                .collect(Collectors.toList());

        long hornetsPower;

        for (int i = 0; i < beehives.size(); i++) {

            if (hornets.isEmpty()) {
                break;
            }

            hornetsPower = hornets.stream().mapToLong(Long::valueOf).sum();
            long beehiveCount = beehives.get(i);
            long newBeehiveCount = beehives.get(i) - hornetsPower;
            if (newBeehiveCount <= 0) {
                beehives.remove(i);
                i--;
            } else {
                beehives.set(i, newBeehiveCount);
            }

            if (beehiveCount >= hornetsPower) {
                hornets.remove(0);
            }
        }

        if (beehives.isEmpty()) {
            for (Long hornet : hornets) {
                System.out.printf("%d ", hornet);
            }
        } else {
            for (Long beehive : beehives) {
                System.out.printf("%d ", beehive);
            }
        }
    }
}
