package entities;

import entities.interfaces.Airport;
import entities.interfaces.Bag;
import entities.interfaces.Passenger;
import entities.interfaces.Trip;

import java.util.List;

public class AirportImpl implements Airport {

    private List<Bag> checkedInBags;

    private List<Bag> confiscatedBags;

    private List<Passenger> passengers;

    private List<Trip> trips;

    @Override
    public List<Bag> getCheckedInBags() {
        return this.checkedInBags;
    }

    @Override
    public List<Bag> getConfiscatedBags() {
        return this.confiscatedBags;
    }

    @Override
    public List<Passenger> getPassengers() {
        return this.passengers;
    }

    @Override
    public List<Trip> getTrips() {
        return this.trips;
    }

    @Override
    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    @Override
    public void addCheckedBag(Bag bag) {
        this.checkedInBags.add(bag);
    }

    @Override
    public void addConfiscatedBag(Bag bag) {
        this.confiscatedBags.add(bag);
    }

    @Override
    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    @Override
    public Passenger getPassenger(String username) {

        Passenger passenger = null;

        if (username != null) {
            passenger = passengers.stream()
                    .filter(p -> p.getUsername().equals(username))
                    .findAny().orElse(null);
        }

        return passenger;
    }

    @Override
    public Trip getTrip(String id) {

        Trip trip = null;

        if (id != null) {
            trip = trips.stream()
                    .filter(t -> t.getId().equals(id))
                    .findAny().orElse(null);
        }

        return trip;
    }
}
