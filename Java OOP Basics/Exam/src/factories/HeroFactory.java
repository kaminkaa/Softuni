package factories;

import entities.heroes.endurance.Nord;
import entities.heroes.endurance.Orc;
import entities.heroes.strength.Khajiit;
import entities.heroes.strength.Redguard;
import entities.heroes.willpower.Breton;
import entities.heroes.willpower.Dunmer;
import interfaces.Hero;

public class HeroFactory {
    private HeroFactory() {}

    public static Hero createHero (String heroType, String heroName, int health, int fatigue, int magicka) {
        switch (heroType) {
            case "Redguard":
                return new Redguard(heroName, magicka, fatigue, health);
            case "Khajiit":
                return new Khajiit(heroName, magicka, fatigue, health);
            case "Orc":
                return new Orc(heroName, magicka, fatigue, health);
            case "Nord":
                return new Nord(heroName, magicka, fatigue, health);
            case "Breton":
                return new Breton(heroName, magicka, fatigue, health);
            case "Dunmer":
                return new Dunmer(heroName, magicka, fatigue, health);
            default:
                return null;
        }
    }
}
