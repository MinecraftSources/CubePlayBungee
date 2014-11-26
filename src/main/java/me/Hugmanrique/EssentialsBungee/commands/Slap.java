package me.Hugmanrique.EssentialsBungee.commands;

/**
 * Created by Hugo on 26/11/2014.
 */
import me.Hugmanrique.EssentialsBungee.BungeeEssentials;
import me.Hugmanrique.EssentialsBungee.Messages;
import me.Hugmanrique.EssentialsBungee.permissions.Permission;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Slap extends Command {

    public Slap() {
        super("slap", Permission.SLAP.toString(), new String[]{"pegar", "abofetear"});
    }

    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = null;
        if(sender instanceof ProxiedPlayer) {
            player = (ProxiedPlayer)sender;
        }

        if(args.length > 0) {
            ProxiedPlayer enemy = BungeeEssentials.me.getProxy().getPlayer(args[0]);
            if(enemy != null) {
                sender.sendMessage(ChatColor.GREEN + "Has abofeteado a " + ChatColor.YELLOW + enemy.getName() + ChatColor.GREEN + ", Apuesto a que te has sentido mejor, ¿No?");
                enemy.sendMessage(ChatColor.GREEN + "Has sido abofeteado Globalmente por " + (player == null?"GOD":player.getName()));
            } else {
                sender.sendMessage(Messages.lazyColour(Messages.PLAYER_OFFLINE));
            }
        } else {
            sender.sendMessage(Messages.lazyColour(Messages.INVALID_ARGS));
        }

    }
}
