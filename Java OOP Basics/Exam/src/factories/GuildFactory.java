package factories;

import entities.guilds.Guild;

public class GuildFactory {
    private GuildFactory() {}

    public static Guild createGuild(String guildName) {
        return new Guild(guildName);
    }
}
