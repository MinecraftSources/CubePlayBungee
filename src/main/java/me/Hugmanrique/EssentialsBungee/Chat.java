package me.Hugmanrique.EssentialsBungee;

/**
 * Created by Hugo on 26/11/2014.
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.Map.Entry;
import me.Hugmanrique.EssentialsBungee.Messages;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Chat {

    private static WeakHashMap messages = new WeakHashMap();


    public static void sendMessage(CommandSender sender, ProxiedPlayer recipient, String message) {
        if(recipient != null) {
            ProxiedPlayer player = null;
            if(sender instanceof ProxiedPlayer) {
                player = (ProxiedPlayer)sender;
            }

            String msg = Messages.MESSAGE;
            if(player != null) {
                msg = msg.replace("{SERVER}", player.getServer().getInfo().getName());
            }

            msg = msg.replace("{SENDER}", sender.getName());
            msg = msg.replace("{RECIPIENT}", recipient.getName());
            msg = msg.replace("{MESSAGE}", message);
            msg = msg.replace("{TIME}", getTime());
            msg = Messages.lazyColour(msg);
            sender.sendMessage(msg);
            recipient.sendMessage(msg);
            if(player != null) {
                messages.put(recipient.getUniqueId(), player.getUniqueId());
            }
        } else {
            sender.sendMessage(Messages.lazyColour(Messages.PLAYER_OFFLINE));
        }

    }

    public static String getTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(cal.getTime());
    }

    public static UUID reply(ProxiedPlayer player) {
        Iterator i$ = messages.entrySet().iterator();

        Entry uuid;
        do {
            if(!i$.hasNext()) {
                return null;
            }

            uuid = (Entry)i$.next();
        } while(uuid.getKey() != player.getUniqueId());

        return (UUID)uuid.getValue();
    }

}
