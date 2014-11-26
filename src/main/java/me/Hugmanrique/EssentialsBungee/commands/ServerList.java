package me.Hugmanrique.EssentialsBungee.commands;

/**
 * Created by Hugo on 26/11/2014.
 */
import java.util.Iterator;
import me.Hugmanrique.EssentialsBungee.BungeeEssentials;
import me.Hugmanrique.EssentialsBungee.Messages;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;

public class ServerList extends Command {

    public ServerList() {
        super("glist");
    }

    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(Messages.lazyColour(Messages.GLIST_HEADER));
        Iterator i$ = BungeeEssentials.me.getProxy().getServers().values().iterator();

        while(i$.hasNext()) {
            ServerInfo info = (ServerInfo)i$.next();
            String message = Messages.GLIST_SERVER;
            message = message.replace("{SERVER}", info.getName());
            message = message.replace("{DENSITY}", this.getDensity(info.getPlayers().size()));
            message = message.replace("{COUNT}", "" + info.getPlayers().size());
            sender.sendMessage(Messages.lazyColour(message));
        }

    }

    public String getDensity(int players) {
        return this.getColour(players) + " (" + players + ") ";
    }

    public ChatColor getColour(int players) {
        int online = BungeeEssentials.me.getProxy().getOnlineCount();
        int percent = (int)((float)players * 100.0F / (float)online);
        return percent < 33?ChatColor.RED:(percent > 33 && percent < 66?ChatColor.GOLD:ChatColor.GREEN);
    }
}
