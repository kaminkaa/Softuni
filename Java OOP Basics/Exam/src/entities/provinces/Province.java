package entities.provinces;

import entities.guilds.Guild;
import interfaces.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Province {
    private String name;
    private List<Guild> guilds;

    public Province(String name) {
        this.name = name;
        this.guilds = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Guild> getGuilds() {
        return this.guilds;
    }

    public String addGuild(Guild guild) {
        this.guilds.add(guild);
        return String.format("Added Guild: %s", guild.getName());
    }

    public String removeGuild(Guild guild) {
        this.guilds.remove(guild);
        return String.format("Removed guild [%s] with %d members.", guild.getName(), guild.getGuildSize());
    }

    public Guild getGuildByName(String guildName) {
        for (Guild guild : this.guilds) {
            if (guild.getName().equals(guildName)) {
                return guild;
            }
        }
        return null;
    }

    public boolean contains(String guildName) {
        for (Guild guild : this.guilds) {
            if (guild.getName().equals(guildName)) {
                return true;
            }
        }
        return false;
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Province: %s", this.getName()));
        List<Guild> guilds = this.getGuilds();

        if (guilds.isEmpty()) {
            sb.append("\n#Guilds: None");
        } else {
            sb.append("\n#Guilds: ");

            Comparator<Guild> byGuildPower = Comparator.comparing(guild -> guild.getGuildPower(), Comparator.reverseOrder());
            Comparator<Guild> byName = Comparator.comparing(guild -> guild.getName());
            Comparator<Guild> byTotalPointsThenName = byGuildPower.thenComparing(byName);

            Collections.sort(guilds, byTotalPointsThenName);

            for (Guild guild : guilds) {
                sb.append(String.format("\n##Guild: Name: %s, Power: %.2f, Size: %d", guild.getName(), guild.getGuildPower(), guild.getGuildSize()));
            }
        }
        return sb.toString();
    }
}
