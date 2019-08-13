import core.EngineController;
import core.controllers.AirportManager;
import core.controllers.FlightManager;
import core.interfaces.Engine;
import core.io.ConsoleReader;
import core.io.ConsoleWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ConsoleReader reader = new ConsoleReader();

        ConsoleWriter writer = new ConsoleWriter();

        AirportManager airportManager = new AirportManager();

//        FlightManager flightManager = new FlightManager();

        Engine engine = new EngineController(reader, writer, airportManager, null);

        engine.run();
    }
}
