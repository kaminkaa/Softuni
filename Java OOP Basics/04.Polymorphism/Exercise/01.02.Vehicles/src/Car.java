public class Car extends Vehicle {
    public Car(double fuelQty, double fuelPerKm, double tankCapacity) {
        super(fuelQty, fuelPerKm, tankCapacity);
    }

    @Override
    protected void calculateSummerFuelConsumption() {
        double summerConsumption = super.getFuelPerKm() + 0.9;
        super.setFuelPerKm(summerConsumption);
    }
}
