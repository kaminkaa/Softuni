package P03_Ferrari;

public class Ferrari implements Car {
    private String model;
    private String driver;

    public Ferrari() {
        this.model = "488-Spider";
    }

    public String getModel() {
        return this.model;
    }

    public String getDriver() {
        return this.driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String useGasPedal() {
        return "Zadu6avam sA!";
    }
}
