package entities;

import entities.interfaces.Bag;
import entities.interfaces.Passenger;

import java.util.List;

public class PassengerImpl implements Passenger {

    private String username;

    private List<Bag> bags;

    public PassengerImpl(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public List<Bag> getBags() {
        return this.bags;
    }

    public void addBag(Bag bag) {
        this.bags.add(bag);
    }
}
