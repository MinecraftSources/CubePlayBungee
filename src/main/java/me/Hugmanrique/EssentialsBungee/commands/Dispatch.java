package me.Hugmanrique.EssentialsBungee.commands;

/**
 * Created by Hugo on 26/11/2014.
 */
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import me.Hugmanrique.EssentialsBungee.BungeeEssentials;
import me.Hugmanrique.EssentialsBungee.Messages;
import me.Hugmanrique.EssentialsBungee.permissions.Permission;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Command;

public class Dispatch extends Command {

    public Dispatch() {
        super("dispatch", Permission.ADMIN_DISPATCH.toString(), new String[0]);
    }

    public void execute(CommandSender commandSender, String[] args) {
        if(args.length > 0) {
            String send = Arrays.toString(args);
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Dispatch");
            ByteArrayOutputStream messageBytes = new ByteArrayOutputStream();
            DataOutputStream stream = new DataOutputStream(messageBytes);

            try {
                stream.writeUTF(send);
            } catch (IOException var10) {
                BungeeEssentials.me.getLogger().severe("Error al escribir los datos");
                return;
            }

            byte[] bytes = messageBytes.toByteArray();
            out.writeShort(bytes.length);
            out.write(bytes);
            bytes = out.toByteArray();
            BungeeEssentials.me.getLogger().info("Comando mandado por el canal de Dispatch");
            Iterator i$ = BungeeEssentials.me.getProxy().getServers().values().iterator();

            while(i$.hasNext()) {
                ServerInfo server = (ServerInfo)i$.next();
                server.sendData("BungeeEssentials", bytes);
            }
        } else {
            commandSender.sendMessage(Messages.lazyColour(Messages.INVALID_ARGS));
        }

    }
}