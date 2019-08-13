import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _05_SpeedRacing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();
        String[] line;

        for (int i = 0; i < n; i++) {
            line = reader.readLine().split("\\s+");

            Car currentCar = new Car(line[0], Double.parseDouble(line[1]), Double.parseDouble(line[2]));
            cars.add(currentCar);
        }

        line = reader.readLine().split("\\s+");
        while (!line[0].equals("End")) {
            int carModelIndex = Car.models.indexOf(line[1]);
            if(!cars.get(carModelIndex).Drive(Integer.parseInt(line[2]))) {
                System.out.println("Insufficient fuel for the drive");
            }

            line = reader.readLine().split("\\s+");
        }

        for (Car car : cars) {
            System.out.printf("%s %.2f %d\n", car.model,  car.fuelAmount, car.distanceTraveled);
        }
    }

    static class Car {
        private static List<String> models = new ArrayList<>();

        public String model;
        public double fuelAmount;
        public double fuelCostPerKm;
        public int distanceTraveled;

        public Car(String model, double fuelAmount, double fuelCostPerKm) {
            this.model = model;
            this.fuelAmount = fuelAmount;
            this.fuelCostPerKm = fuelCostPerKm;
            this.distanceTraveled = 0;

            models.add(model);
        }

        public boolean Drive(int kilometers) {
            if(this.fuelAmount >= kilometers * this.fuelCostPerKm) {
                this.fuelAmount -= kilometers * this.fuelCostPerKm;
                this.distanceTraveled += kilometers;
                return true;
            }

            return false;
        }
    }
}
