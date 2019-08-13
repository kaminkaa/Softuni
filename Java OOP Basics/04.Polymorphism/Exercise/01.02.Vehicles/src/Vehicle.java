import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQty;
    private double fuelPerKm;
    private double tankCapacity;

    protected Vehicle(double fuelQty, double fuelPerKm, double tankCapacity) {
        this.fuelQty = fuelQty;
        this.fuelPerKm = fuelPerKm;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQty() {
        return this.fuelQty;
    }

    protected void setFuelQty(double newFuel) {
        this.fuelQty = newFuel;
    }

    protected void refuel(double newFuel) {
        if (newFuel <= 0) {
            System.out.println("Fuel must be a positive number");
        } else if (this.tankCapacity - newFuel > 0){
            this.fuelQty += newFuel;
        } else {
            System.out.println("Cannot fit fuel in tank");
        }
    }

    public double getFuelPerKm() {
        return this.fuelPerKm;
    }

    protected void setFuelPerKm(double newFuelPerKm) {
        this.fuelPerKm = newFuelPerKm;
    }

    public String drive(double distance) {
        DecimalFormat df = new DecimalFormat("##.##");

        double fuelNeeded = distance * this.fuelPerKm;
        if (fuelNeeded > this.fuelQty) {
            return "needs refueling";
        } else {
            this.setFuelQty(this.getFuelQty() - fuelNeeded);
            return "travelled " + df.format(distance) + " km";
        }
    }

    protected abstract void calculateSummerFuelConsumption();
}
