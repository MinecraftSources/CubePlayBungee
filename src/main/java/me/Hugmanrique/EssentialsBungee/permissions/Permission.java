package me.Hugmanrique.EssentialsBungee.permissions;

/**
 * Created by Hugo on 26/11/2014.
 */
import net.md_5.bungee.api.CommandSender;

public enum Permission {

    ADMIN_SEND("ADMIN_SEND", 0, "gssentials.admin.send"),
    ADMIN_SENDALL("ADMIN_SENDALL", 1, "gssentials.admin.sendall"),
    ADMIN_DISPATCH("ADMIN_DISPATCH", 2, "gssentials.admin.dispatch"),
    ADMIN_ALERT("ADMIN_ALERT", 3, "gssentials.admin.alert"),
    SLAP("SLAP", 4, "gssentials.slap");
    private final String node;
    // $FF: synthetic field
    private static final Permission[] $VALUES = new Permission[]{ADMIN_SEND, ADMIN_SENDALL, ADMIN_DISPATCH, ADMIN_ALERT, SLAP};


    private Permission(String var1, int var2, String node) {
        this.node = node;
    }

    public static boolean has(CommandSender sender, Permission permission) {
        return sender.hasPermission(permission.toString());
    }

    public String toString() {
        return this.node;
    }

}
