package engine;

import entities.guilds.Guild;
import entities.provinces.Province;
import factories.GuildFactory;
import factories.HeroFactory;
import factories.ProvinceFactory;
import interfaces.Hero;

import java.util.*;

public class Manager {
    private Map<String, Province> provinces;
    private List<String> heroTypes = new ArrayList<String>(){{
        add("Redguard");
        add("Khajiit");
        add("Orc");
        add("Nord");
        add("Breton");
        add("Dunmer");
    }};

    public Manager() {
        this.provinces = new LinkedHashMap<>();
    }

    public String createProvince(String provinceName) {
        if (this.provinces.containsKey(provinceName)) {
            return String.format("Province with name %s already exists!", provinceName);
        }

        this.provinces.put(provinceName, ProvinceFactory.createProvince(provinceName));
        return String.format("Created province %s", provinceName);
    }

    public boolean provinceExists(String provinceName) {
        return this.provinces.containsKey(provinceName);
    }

    public String addHero(String provinceName, String guildName, String heroType, String heroName, int health, int fatigue, int magicka) {
        if (!this.heroTypes.contains(heroType)) {
            return "No such hero type!";
        }

        if (health < 1 || fatigue < 1 || magicka < 1) {
            return "Invalid character stats!";
        }

        if (!this.provinces.get(provinceName).contains(guildName)) {
            Guild newGuild = GuildFactory.createGuild(guildName);
            this.provinces.get(provinceName).addGuild(newGuild);
        }

        this.provinces.get(provinceName).getGuildByName(guildName).addHero(HeroFactory.createHero(heroType, heroName, health, fatigue, magicka));
        return  String.format("Added hero: %s", heroName);
    }

    public String addGuild(String provinceName, String guildName) {
        if (this.provinces.get(provinceName).contains(guildName)) {
            return "Guild already exists";
        }

        this.provinces.get(provinceName).addGuild(GuildFactory.createGuild(guildName));
        return String.format("Added Guild: %s", guildName);
    }

    public String guildDetails(String provinceName, String guildName) {
        if (!this.provinces.get(provinceName).contains(guildName)) {
            return String.format("Guild [%s] does not exist.", guildName);
        }

        List<Hero> heroes = this.provinces.get(provinceName).getGuildByName(guildName).getHeroes();
        if (heroes.isEmpty()) {
            return "###Heroes: None";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Guild : %s\n", guildName));
        sb.append("###Heroes: \n");

        Comparator<Hero> byTotalPointsDescending = Comparator.comparing(hero -> hero.getTotalPoints(), Comparator.reverseOrder());
        Comparator<Hero> byName = Comparator.comparing(hero -> hero.getName());
        Comparator<Hero> byTotalPointsThenName = byTotalPointsDescending.thenComparing(byName);

        Collections.sort(heroes, byTotalPointsThenName);

        for (Hero hero : heroes) {
            sb.append(String.format("Hero: %s, Offense: %.2f, Defense: %.2f\n", hero.getName(), hero.getOffense(), hero.getDefense()));
        }

        return sb.toString();
    }

    public String heroDetails(String provinceName, String guildName, String heroName) {
        if (!this.provinces.get(provinceName).contains(guildName)) {
            return String.format("Guild [%s] does not exist.", guildName);
        }

        Hero hero = this.provinces.get(provinceName).getGuildByName(guildName).getHeroByName(heroName);
        if (hero == null) {
            return "No such hero in this guild!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Hero: %s, Type: [%s]", hero.getName(), hero.getHeroType()));
        sb.append("\n#Stats: ");
        sb.append(String.format("\nHealth: %d", hero.getHealth()));
        sb.append(String.format("\nFatigue: %s", hero.fatigueValue()));
        sb.append(String.format("\nMagicka: %s", hero.magickaValue()));

        if (hero.getHeroType().equals("ORSIMER") || hero.getHeroType().equals("NORD")) {
            sb.append("#Endurance bonuses:\n");
            sb.append(String.format("Magic resistance: +%.2f defense.", hero.magicResistanceValue()));
        }

        if (hero.getHeroType().equals("REDGUARD") || hero.getHeroType().equals("KHAJIIT")) {
            sb.append("\n#Strength bonuses:");
            sb.append(String.format("\nMagic damage: +%.1f offense.", hero.magicDamageValue()));
        }

        return sb.toString();
    }

    public String removeGuild(String provinceName, String guildName) {
        if (!this.provinces.get(provinceName).contains(guildName)) {
            return String.format("Guild [%s] does not exist.", guildName);
        }

        Guild guild = this.provinces.get(provinceName).getGuildByName(guildName);
        this.provinces.get(provinceName).removeGuild(guild);
        return String.format("Removed guild %s with %d members", guildName, guild.getGuildSize());
    }

    public String removeHero(String provinceName, String guildName, String heroName) {
        if (!this.provinces.get(provinceName).contains(guildName)) {
            return String.format("Guild [%s] does not exist.", guildName);
        }

        Guild guild = this.provinces.get(provinceName).getGuildByName(guildName);
        Hero hero = guild.getHeroByName(heroName);

        return guild.removeHero(hero);
    }

    public String fight(String provinceName, String guildName1, String heroName1, String guildName2, String heroName2) {
        if (guildName1.equals(guildName2)) {
            return "Heroes from the same guild can not fight each other.";
        }

        Guild guild1 = this.provinces.get(provinceName).getGuildByName(guildName1);
        Guild guild2 = this.provinces.get(provinceName).getGuildByName(guildName2);

        Hero hero1 = guild1.getHeroByName(heroName1);
        Hero hero2 = guild2.getHeroByName(heroName2);

        if (hero1 == null || hero2 == null) {
            return "No such hero in this guild!";
        }

        String winner, loser;

        while (true) {
            if (hero1.getHealth() < hero2.getHealth()) {
                hero1.attack(hero2);
            } else if (hero2.getHealth() < hero1.getHealth()) {
                hero2.attack(hero1);
            } else if (hero1.getHealth() == hero2.getHealth()) {
                if (hero1.getOffense() < hero2.getOffense()) {
                    hero1.attack(hero2);
                } else {
                    hero2.attack(hero1);
                }
            }

            if (hero1.isDead()) {
                winner = hero2.getName();
                loser = hero1.getName();
                guild1.removeHero(hero1);
                break;
            }

            if (hero2.isDead()) {
                winner = hero1.getName();
                loser = hero2.getName();
                guild2.removeHero(hero2);
                break;
            }
        }

        return String.format("Hero %s sliced hero %s.", winner, loser);
    }

    public String printAll() {
        StringBuilder sb = new StringBuilder();
        Map<String, Province> provinces = this.provinces;
        Comparator<Map.Entry<String,Province>> byName = Comparator.comparing(kvp -> kvp.getValue().getName());

        provinces.entrySet().stream()
                .sorted(byName)
                .forEach(kvp -> sb.append(kvp.getValue().getString()).append("\n"));

        return sb.toString();
    }

}
