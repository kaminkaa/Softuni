import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SoftUniKaraoke {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> applicants = Arrays.stream(reader.readLine().split(", "))
                .collect(Collectors.toList());
        List<String> availableSongs = Arrays.stream(reader.readLine().split(", "))
                .collect(Collectors.toList());

        String[] input = reader.readLine().split(", ");
        LinkedHashMap<String,HashSet<String>> participants = new LinkedHashMap<>();

        while (true){
            if (input[0].equals("dawn")) { break; }

            String participantName = input[0];
            String song = input[1];
            String award = input[2];

            if (applicants.contains(participantName) && availableSongs.contains(song)) {
                if (participants.containsKey(participantName)) {
                    participants.get(participantName).add(award);
                } else {
                    participants.put(participantName,new HashSet<>());
                    participants.get(participantName).add(award);
                }
            }

            input = reader.readLine().split(", ");
        }

        if (participants.isEmpty()) {
            System.out.printf("No awards");
        }

        Comparator<Map.Entry<String, HashSet<String>>> compareByAwardsCount
                = Comparator.comparing(kvp -> kvp.getValue().stream().count(),Comparator.reverseOrder());

        Comparator<Map.Entry<String, HashSet<String>>> compareByParticipantName
                = Comparator.comparing(kvp -> kvp.getKey());


        participants.entrySet().stream()
                .sorted(compareByAwardsCount.thenComparing(compareByParticipantName))
                .forEach( e -> {
                    System.out.printf("%s: %d awards\n", e.getKey(), e.getValue().stream().count());
                    e.getValue().stream().sorted().forEach(award -> System.out.printf("--%s\n", award));
                });
    }
}
