package me.Hugmanrique.EssentialsBungee.commands;

/**
 * Created by Hugo on 26/11/2014.
 */
        import me.Hugmanrique.EssentialsBungee.BungeeEssentials;
        import me.Hugmanrique.EssentialsBungee.Messages;
        import net.md_5.bungee.api.CommandSender;
        import net.md_5.bungee.api.connection.ProxiedPlayer;
        import net.md_5.bungee.api.plugin.Command;

public class Search extends Command {

    public Search() {
        super("buscar");
    }

    public void execute(CommandSender sender, String[] args) {
        if(args.length > 0) {
            ProxiedPlayer player = BungeeEssentials.me.getProxy().getPlayer(args[0]);
            if(player != null) {
                String message = Messages.FIND;
                message = message.replace("{SERVER}", player.getServer().getInfo().getName());
                message = message.replace("{PLAYER}", player.getName());
                sender.sendMessage(Messages.lazyColour(message));
            } else {
                sender.sendMessage(Messages.lazyColour(Messages.PLAYER_OFFLINE));
            }
        }

    }
}
