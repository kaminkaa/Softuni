import java.text.DecimalFormat;

public class Bus extends Vehicle {
    protected Bus(double fuelQty, double fuelPerKm, double tankCapacity) {
        super(fuelQty, fuelPerKm, tankCapacity);
    }

    @Override
    protected void calculateSummerFuelConsumption() {
        double summerConsumption = super.getFuelPerKm() + 1.4;
        super.setFuelPerKm(summerConsumption);
    }

    @Override
    public String drive(double distance) {
        DecimalFormat df = new DecimalFormat("##.##");

        double fuelNeeded = distance * (this.getFuelPerKm() + 1.4);
        if (fuelNeeded > this.getFuelQty()) {
            return "needs refueling";
        } else {
            this.setFuelQty(this.getFuelQty() - fuelNeeded);
            return "travelled " + df.format(distance) + " km";
        }
    }

    public String driveEmpty(double distance) {
        return super.drive(distance);
    }
}
