package entities.heroes;

import interfaces.Hero;

public abstract class Characters implements Hero {
    private String name;
    private int magicka;
    private int fatigue;
    private int health;
    private String heroType;

    public Characters(String name, int magicka, int fatigue, int health, String heroType) {
        this.name = name;
        this.magicka = magicka;
        this.fatigue = fatigue;
        this.health = health;
        this.heroType = heroType;
    }

    @Override
    public String fatigueValue() {
        return this.getFatigue() + "";
    }

    @Override
    public String magickaValue() {
        return this.getMagicka() + "";
    }

    public String getName() {
        return this.name;
    }

    protected int getMagicka() {
        return this.magicka;
    }

    protected int getFatigue() {
        return this.fatigue;
    }

    public int getHealth() {
        return this.health;
    }

    public String getHeroType() {
        return this.heroType;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean isDead() {
        return this.getHealth() < 1;
    }

    @Override
    public double getTotalPoints() {
        return this.getOffense() + this.getDefense();
    }

    @Override
    public void attack(Hero hero) {
        hero.receiveDamage(this.getOffense());
    }

    @Override
    public void receiveDamage(double amount) {
        int value = (int)(this.getHealth() - Math.floor(amount));
        this.setHealth(value);
    }
}
