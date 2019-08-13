import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split("\\s\\|\\s");

        String username = line[0];
        String characterType = line[1];
        double specialpoints = Double.parseDouble(line[2]);
        int level = Integer.parseInt(line[3]);

        if (characterType.equals("Demon")) {
            CharacterInterface character = new Demon(username, characterType, specialpoints, level);
            System.out.println(character.printInfo());
        } else {
            CharacterInterface character = new Archangel(username, characterType, (int)specialpoints, level);
            System.out.println(character.printInfo());
        }
    }
}
