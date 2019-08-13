package engine;

import io.ConsoleReader;
import io.ConsoleWriter;

public class Engine implements Runnable {
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private Manager manager;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.manager = new Manager();
    }

    @Override
    public void run() {
        String input = reader.readLine();
        String selected = "";

        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String provinceName, guildName, heroName;
            String result;

            switch (command) {
                case "CREATE_PROVINCE:":
                    provinceName = tokens[1];
                    selected = provinceName;
                    writer.writeLine(manager.createProvince(provinceName));
                    break;
                case "SELECT:":
                    provinceName = tokens[1];
                    if (selected.equals(provinceName)) {
                        writer.writeLine(String.format("Province %s has already been selected!", provinceName));
                    } else if (manager.provinceExists(provinceName)) {
                        selected = provinceName;
                        writer.writeLine(String.format("Province %s selected!", provinceName));
                    } else {
                        writer.writeLine(String.format("Province %s does not exist", provinceName));
                    }
                    break;
                case "ADD_HERO:":
                    if (selected.equals("")) {
                        writer.writeLine("No province selected!");
                    } else {
                        guildName = tokens[1];
                        String heroType = tokens[2];
                        heroName = tokens[3];
                        int health = Integer.parseInt(tokens[4]);
                        int fatigue = Integer.parseInt(tokens[5]);
                        int magicka = Integer.parseInt(tokens[6]);

                        writer.writeLine(manager.addHero(selected, guildName, heroType, heroName, health, fatigue, magicka));
                    }
                    break;
                case "ADD_GUILD:":
                    if (selected.equals("")) {
                        writer.writeLine("No province selected!");
                    } else {
                        guildName = tokens[1];
                        writer.writeLine(manager.addGuild(selected, guildName));
                    }
                    break;
                case "DETAILS:":
                    if (selected.equals("")) {
                        writer.writeLine("No province selected!");
                    } else {
                        guildName = tokens[1];
                        heroName = (tokens.length == 3) ? tokens[2] : "";

                        if (heroName.equals("")) {
                            writer.writeLine(manager.guildDetails(selected, guildName));
                        } else {
                            writer.writeLine(manager.heroDetails(selected, guildName, heroName));
                        }
                    }
                    break;
                case "REMOVE:":
                    if (selected.equals("")) {
                        writer.writeLine("No province selected!");
                    } else {
                        guildName = tokens[1];
                        heroName = (tokens.length == 3) ? tokens[2] : "";

                        if (heroName.equals("")) {
                            writer.writeLine(manager.removeGuild(selected, guildName));
                        } else {
                            writer.writeLine(manager.removeHero(selected, guildName, heroName));
                        }
                    }
                    break;
                case "FIGHT:":
                    if (selected.equals("")) {
                        writer.writeLine("No province selected!");
                    } else {
                        String guildName1 = tokens[1];
                        String heroName1 = tokens[2];
                        String guildName2 = tokens[3];
                        String heroName2 = tokens[4];

                        writer.writeLine(manager.fight(selected, guildName1, heroName1, guildName2, heroName2));
                    }
                    break;
            }

            input = reader.readLine();
            writer.writeLine("---");
        }

        writer.writeLine(manager.printAll());
    }
}
