package app.engine;

import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.util.Arrays;

public class Engine {
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private Manager manager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new Manager();
    }

    public void run() {
        int[] paramsColony = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        manager.createColony(paramsColony[0], paramsColony[1]);

        String input = reader.readLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String colonistId, familyId, result;

            switch (command) {
                case "insert":
                    String classs = tokens[1];
                    colonistId = tokens[2];
                    familyId = tokens[3];
                    int talent = Integer.parseInt(tokens[4]);
                    int age = Integer.parseInt(tokens[5]);
                    String sign = (tokens.length == 7) ? tokens[6] : "";
                    result = manager.addColonist(classs, colonistId, familyId, talent, age, sign);
                    if (!"".equals(result)) {
                        writer.writeLine(result);
                    }
                    break;
                case "remove":
                    String modificator = tokens[1];
                    familyId = tokens[2];

                    switch (modificator) {
                        case "family":
                            manager.removeFamily(familyId);
                            break;
                        case "colonist":
                            colonistId = tokens[3];
                            manager.removeColonist(familyId, colonistId);
                            break;
                            default:
                                break;
                    }
                    break;
                case "grow":
                    int years = Integer.parseInt(tokens[1]);
                    manager.grow(years);
                    break;
                case "potential":
                    writer.writeLine(manager.getPotential());
                    break;
                case "capacity":
                    writer.writeLine(manager.getCapacity());
                    break;
                case "family":
                    familyId = tokens[1];
                    writer.writeLine(manager.getFamilyInfo(familyId));
                    break;
                    default:
                        break;
            }

            input = reader.readLine();
        }
    }
}
