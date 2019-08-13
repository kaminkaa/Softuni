package entities;

import entities.airplanes.interfaces.FlyingMachine;
import entities.interfaces.Trip;

public class TripImpl implements Trip {

    private String id;

    private String source;

    private String destination;

    private boolean isCompleted;

    private FlyingMachine airplane;

    public TripImpl(String source, String destination, FlyingMachine airplane) {
        this.source = source;
        this.destination = destination;
        this.airplane = airplane;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getSource() {
        return this.source;
    }

    @Override
    public String getDestination() {
        return this.destination;
    }

    @Override
    public boolean isCompleted() {
        return this.isCompleted;
    }

    @Override
    public FlyingMachine getFlyingMachine() {
        return this.airplane;
    }

    @Override
    public void complete() {
        this.isCompleted = true;
    }
}
