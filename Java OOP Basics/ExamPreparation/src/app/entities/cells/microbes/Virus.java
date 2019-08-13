package app.entities.cells.microbes;

public class Virus extends Microbe {

    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + super.getVirulence();
    }

    @Override
    public String toString() {
        return String.format("%s\n--------Health: %d | Virulence: %d | Energy: %d", super.toString(), super.getHealth(), super.getVirulence(), this.getEnergy());
    }
}
