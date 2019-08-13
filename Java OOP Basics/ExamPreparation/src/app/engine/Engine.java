package app.engine;

import app.io.ConsoleReader;
import app.io.ConsoleWriter;

// corresponds with the health manager
public class Engine {
    //console reader and writer, health manager
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private HealthManager healthManager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.healthManager = new HealthManager();
    }

    public void run() {
        String input = reader.readLine();

        while (!input.equals("BEER IS COMING")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String organismName = tokens[1];
            String result;

            switch (command) {
                case "checkCondition":
                    result = healthManager.checkCondition(organismName);
                    if (!result.equals("")) {
                        writer.writeLine(result);
                    }
                    break;
                case "createOrganism":
                    writer.writeLine(healthManager.createOrganism(organismName));
                    break;
                case "addCluster":
                    String id = tokens[2];
                    int rows = Integer.parseInt(tokens[3]);
                    int cols = Integer.parseInt(tokens[4]);

                    result = healthManager.addCluster(organismName, id, rows, cols);
                    if (!result.equals("")) {
                        writer.writeLine(result);
                    }
                    break;
                case "addCell":
                    String clusterId = tokens[2];
                    String cellType = tokens[3];
                    String cellId = tokens[4];
                    int health = Integer.parseInt(tokens[5]);
                    int positionRow = Integer.parseInt(tokens[6]);
                    int positionCol = Integer.parseInt(tokens[7]);
                    int additionalProperty = Integer.parseInt(tokens[8]);

                    result = healthManager.addCell(organismName, clusterId, cellType, cellId, health, positionRow, positionCol, additionalProperty);
                    if (!result.equals("")) {
                        writer.writeLine(result);
                    }
                    break;
                case "activateCluster":
                    result = healthManager.activateCluster(organismName);
                    if (!result.equals("")) {
                        writer.writeLine(result);
                    }
                    break;
            }
            input = reader.readLine();
        }
    }
}
