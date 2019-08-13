package entities.guilds;

import interfaces.Hero;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private List<Hero> heroes;

    public Guild(String name) {
        this.name = name;
        this.heroes = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Hero> getHeroes() {
        return this.heroes;
    }

    public String addHero(Hero hero) {
        for (Hero currentHero : this.heroes) {
            if (currentHero.getName().equals(hero.getName())) {
                if (this.currentIsStronger(currentHero, hero)) {
                    return String.format("Hero %s can not be replaced by a weaker one.", hero.getName());
                } else {
                    this.heroes.remove(currentHero);
                    this.heroes.add(hero);
                    return String.format("Updated hero: %s", hero.getName());
                }
            }
        }

        this.heroes.add(hero);
        return String.format("Added hero: %s", hero.getName());
    }

    private boolean currentIsStronger(Hero currentHero, Hero providedHero) {
        return providedHero.getTotalPoints() <= currentHero.getTotalPoints();
    }

    public 	String removeHero(Hero hero) {
        if (this.heroes.contains(hero)) {
            this.heroes.remove(hero);
            return String.format("Successfully removed hero [%s] from guild %s", hero.getName(), this.getName());
        }

        return "No such hero in this guild!";
    }

    public Hero getHeroByName(String heroName) {
        for (Hero currentHero : this.heroes) {
            if (currentHero.getName().equals(heroName)) {
                return currentHero;
            }
        }
        return null;
    }

    public Long getGuildSize() {
        return Long.valueOf(this.heroes.size());
    }

    public double getGuildPower() {
        double guildPower = 0;

        for (Hero currentHero : this.heroes) {
            guildPower += currentHero.getTotalPoints();
        }

        DecimalFormat df = new DecimalFormat("#0.00");
        return Double.parseDouble(df.format(guildPower));
    }

    public String getGuildSpecialization() {
        int willpowerCount = 0;
        int willpowerTotalPoints = 0;
        int enduranceCount = 0;
        int enduranceTotalPoints = 0;
        int strengthCount = 0;
        int strengthTotalPoints = 0;

        for (Hero currentHero : this.heroes) {
            if (currentHero.getHeroType().equals("ORSIMER") || currentHero.getHeroType().equals("NORD")) {
                enduranceCount++;
                enduranceTotalPoints += currentHero.getTotalPoints();
            } else if (currentHero.getHeroType().equals("REDGUARD") || currentHero.getHeroType().equals("KHAJIIT")) {
                strengthCount++;
                strengthTotalPoints += currentHero.getTotalPoints();
            } else {
                willpowerCount++;
                willpowerTotalPoints += currentHero.getTotalPoints();
            }
        }

        if (willpowerCount > enduranceCount && willpowerCount > strengthCount) {
            return "Willpower";
        } else if (enduranceCount > willpowerCount && enduranceCount > strengthCount) {
            return "Endurance";
        } else if (strengthCount > enduranceCount && strengthCount > willpowerCount) {
            return "Strength";
        } else if (willpowerCount == enduranceCount) {
            if (willpowerTotalPoints > enduranceTotalPoints) {
                return "Willpower";
            }
            return "Endurance";
        } else if (willpowerCount == strengthCount) {
            if (willpowerTotalPoints > strengthTotalPoints) {
                return "Willpower";
            }
            return "Strength";
        } else if (enduranceCount == strengthCount) {
            if (enduranceTotalPoints > strengthTotalPoints) {
                return "Endurance";
            }
            return "Strength";
        }
        return "";
    }
}
