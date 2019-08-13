package interfaces;

public interface Hero {
    String getName();

    int getHealth();

    String getHeroType();

    double getOffense();

    double getDefense();

    double getTotalPoints();

    boolean isDead();

    void attack(Hero hero);

    void receiveDamage(double amount);

    String fatigueValue();

    String magickaValue();

    double magicResistanceValue();

    double magicDamageValue();
}
