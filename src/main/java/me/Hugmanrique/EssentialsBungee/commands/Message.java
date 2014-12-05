package me.Hugmanrique.EssentialsBungee.commands;

/**
 * Created by Hugo on 26/11/2014.
 */
        import me.Hugmanrique.EssentialsBungee.BungeeEssentials;
        import me.Hugmanrique.EssentialsBungee.Chat;
        import me.Hugmanrique.EssentialsBungee.Messages;
        import net.md_5.bungee.api.CommandSender;
        import net.md_5.bungee.api.connection.ProxiedPlayer;
        import net.md_5.bungee.api.plugin.Command;

public class Message extends Command {

    public Message() {
        super("mensaje", "", new String[]{"mensaje", "msg", "t", "tell", "decir"});
    }

    public void execute(CommandSender sender, String[] args) {
        if(args.length > 1) {
            ProxiedPlayer recipient = BungeeEssentials.me.getProxy().getPlayer(args[0]);
            Chat.sendMessage(sender, recipient, Messages.combine(0, args));
        } else {
            sender.sendMessage(Messages.lazyColour(Messages.INVALID_ARGS));
        }

    }
}