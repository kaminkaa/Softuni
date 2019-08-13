package entities.heroes.willpower;

import entities.heroes.Characters;

public class Willpower extends Characters {
    private double spellPentration;

    public Willpower(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.setSpellPentration();
    }

    public double getSpellPentration() {
        return this.spellPentration;
    }

    private void setSpellPentration() {
        this.spellPentration = super.getFatigue() * 0.2;
    }

    protected int getMagicka() { return super.getMagicka(); }

    protected int getFatigue() {
        return super.getFatigue();
    }

    @Override
    public double magicResistanceValue() {
        return 0;
    }

    @Override
    public double magicDamageValue() {
        return 0;
    }

    @Override
    public double getOffense() {
        return super.getMagicka() * 1.8 + this.getSpellPentration();
    }

    @Override
    public double getDefense() {
        return super.getHealth();
    }
}
