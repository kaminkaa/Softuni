package P05_BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        List<Identifiable> identifiables = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            Identifiable identifiable;

            if (tokens.length == 3) {
                identifiable = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            } else {
                identifiable = new Robot(tokens[0], tokens[1]);
            }

            identifiables.add(identifiable);
            input = reader.readLine();
        }

        String fakeId = reader.readLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().substring(identifiable.getId().length() - fakeId.length()).equals(fakeId)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}
