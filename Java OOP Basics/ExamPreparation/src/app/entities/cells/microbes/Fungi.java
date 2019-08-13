package app.entities.cells.microbes;

public class Fungi extends Microbe {

    public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return (super.getHealth() + super.getVirulence()) / 4;
    }

    @Override
    public String toString() {
        return String.format("%s\n--------Health: %d | Virulence: %d | Energy: %d", super.toString(), super.getHealth(), super.getVirulence(), this.getEnergy());
    }
}
