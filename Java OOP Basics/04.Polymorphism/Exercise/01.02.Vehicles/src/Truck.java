public class Truck extends Vehicle {
    protected Truck(double fuelQty, double fuelPerKm, double tankCapacity) {
        super(fuelQty, fuelPerKm, tankCapacity);
    }

    @Override
    protected void calculateSummerFuelConsumption() {
        double summerConsumption = super.getFuelPerKm() + 1.6;
        super.setFuelPerKm(summerConsumption);
    }

    @Override
    protected void refuel(double liters) {
        super.refuel(0.95 * liters);
    }
}
