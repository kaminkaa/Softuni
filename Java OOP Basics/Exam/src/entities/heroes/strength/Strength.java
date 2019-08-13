package entities.heroes.strength;
import entities.heroes.Characters;

public class Strength extends Characters {
    private double magicDamage;

    public Strength(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setMagicDamage();
    }

    public double getMagicDamage() {
        return this.magicDamage;
    }

    private void setMagicDamage() {
        this.magicDamage = super.getMagicka() * 0.5;
    }

    protected int getMagicka() { return super.getMagicka(); }

    protected int getFatigue() {
        return super.getFatigue();
    }

    @Override
    public double getOffense() {
        return super.getFatigue() * 1.25 + super.getHealth() * 0.3 + this.getMagicDamage();
    }

    @Override
    public double getDefense() {
        return super.getHealth() + super.getFatigue() * 0.1;
    }

    @Override
    public double magicResistanceValue() {
        return 0;
    }

    @Override
    public double magicDamageValue() {
        return this.getMagicDamage();
    }
}
