package me.Hugmanrique.EssentialsBungee.commands;

/**
 * Created by Hugo on 26/11/2014.
 */
import java.util.UUID;
import me.Hugmanrique.EssentialsBungee.BungeeEssentials;
import me.Hugmanrique.EssentialsBungee.Chat;
import me.Hugmanrique.EssentialsBungee.Messages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Reply extends Command {

    public Reply() {
        super("responder", "", new String[]{"r", "reply"});
    }

    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            if(args.length > 0) {
                ProxiedPlayer player = (ProxiedPlayer)sender;
                UUID uuid = Chat.reply(player);
                ProxiedPlayer recipient = BungeeEssentials.me.getProxy().getPlayer(uuid);
                Chat.sendMessage(player, recipient, Messages.combine(args));
            } else {
                sender.sendMessage(Messages.lazyColour(Messages.INVALID_ARGS));
            }
        } else {
            sender.sendMessage(Messages.lazyColour("&c&l[Error] &fSólo los jugadores pueden responder a Mensajes."));
        }

    }
}