import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FootballStats {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        HashMap<String,HashMap<String,List<String>>> teamStats = new HashMap<>();

        while (true) {
            if (inputLine.equals("Season End")) {break;}

            String[] tokens = inputLine.split(" ");

            String team = tokens[0];
            String opponent = tokens[2];
            String score = tokens[4];

            //team-opponent:
            if(!teamStats.containsKey(team)){
                teamStats.put(team,new HashMap<>());
            }
            if(!teamStats.get(team).containsKey(opponent)){
                teamStats.get(team).put(opponent,new ArrayList<>());
            }
            teamStats.get(team).get(opponent).add(score);

            //opponent-team:
            String reversedScore = score.charAt(2) + ":" + score.charAt(0);
            if(!teamStats.containsKey(opponent)){
                teamStats.put(opponent,new HashMap<>());
            }
            if(!teamStats.get(opponent).containsKey(team)){
                teamStats.get(opponent).put(team,new ArrayList<>());
            }
            teamStats.get(opponent).get(team).add(reversedScore);

            inputLine = reader.readLine();
        }

        inputLine = reader.readLine();
        String[] teamsToPrint = inputLine.split(", ");

        Comparator<Map.Entry<String,List<String>>> compareByOpponent = Comparator.comparing(kvp -> kvp.getKey());
        StringBuilder sb = new StringBuilder();

        for (String teamName : teamsToPrint) {
            teamStats.get(teamName).entrySet().stream()
                    .sorted(compareByOpponent)
                    .forEach(kvp -> {
                        for (String score : kvp.getValue()) {
                            sb.append(teamName).append(" - ").append(kvp.getKey()).append(" -> ").append(score).append("\n");
                        }
                    });
        }

        System.out.println(sb.toString());
    }
}
