import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine = reader.readLine().split(" ");

        Vehicle car = new Car(Double.parseDouble(inputLine[1]), Double.parseDouble(inputLine[2]), Double.parseDouble(inputLine[3]));
        car.calculateSummerFuelConsumption();
        inputLine = reader.readLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(inputLine[1]), Double.parseDouble(inputLine[2]), Double.parseDouble(inputLine[3]));
        truck.calculateSummerFuelConsumption();
        inputLine = reader.readLine().split(" ");
        Vehicle bus = new Bus(Double.parseDouble(inputLine[1]), Double.parseDouble(inputLine[2]), Double.parseDouble(inputLine[3]));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            inputLine = reader.readLine().split(" ");

            switch (inputLine[0]) {
                case "Drive":
                    if (inputLine[1].equals("Car")) {
                        System.out.println("Car " + car.drive(Double.parseDouble(inputLine[2])));
                    } else if (inputLine[1].equals("Truck")){
                        System.out.println("Truck " + truck.drive(Double.parseDouble(inputLine[2])));
                    } else {
                        System.out.println("Bus " + bus.drive(Double.parseDouble(inputLine[2])));
                    }
                    break;
                case "Refuel":
                    if (inputLine[1].equals("Car")) {
                        car.refuel(Double.parseDouble(inputLine[2]));
                    } else if (inputLine[1].equals("Truck")){
                        truck.refuel(Double.parseDouble(inputLine[2]));
                    }  else {
                        bus.refuel(Double.parseDouble(inputLine[2]));
                    }
                    break;
                case "DriveEmpty":
                    System.out.println("Bus " + ((Bus) bus).driveEmpty(Double.parseDouble(inputLine[2])));
                    break;
            }
        }

        System.out.printf("Car: %.2f\n", car.getFuelQty());
        System.out.printf("Truck: %.2f\n", truck.getFuelQty());
        System.out.printf("Bus: %.2f", bus.getFuelQty());
    }
}
