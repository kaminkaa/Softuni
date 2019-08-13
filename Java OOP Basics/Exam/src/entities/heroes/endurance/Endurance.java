package entities.heroes.endurance;

import entities.heroes.Characters;

public class Endurance extends Characters {
    private double magicResistance;

    public Endurance(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health * 2, heroType);
        this.setMagicResistance();
    }

    public double getMagicResistance() {
        return this.magicResistance;
    }

    private void setMagicResistance() {
        this.magicResistance = super.getMagicka() * 0.4;
    }

    protected int getMagicka() { return super.getMagicka(); }

    protected int getFatigue() {
        return super.getFatigue();
    }

    @Override
    public double getOffense() {
        return super.getFatigue();
    }

    @Override
    public double magicResistanceValue() {
        return this.getMagicResistance();
    }

    @Override
    public double magicDamageValue() {
        return 0;
    }

    @Override
    public double getDefense() {
        return super.getHealth() + super.getFatigue() * 0.6 + this.getMagicResistance();
    }
}
