package me.Hugmanrique.EssentialsBungee;

/**
 * Created by Hugo on 26/11/2014.
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import me.Hugmanrique.EssentialsBungee.Messages;
import me.Hugmanrique.EssentialsBungee.commands.CommandRegister;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class BungeeEssentials extends Plugin {

    public static BungeeEssentials me;


    public void onEnable() {
        me = this;
        this.getProxy().registerChannel("BungeeEssentials");
        Configuration config = null;

        try {
            this.saveConfig();
            config = this.loadConfig();
        } catch (Exception var7) {
            this.getLogger().log(Level.SEVERE, "Exception thrown whilst loading config, unable to proceed: ", var7);
        }

        if(config != null) {
            List nope = config.getStringList("enable");
            Messages.FIND = config.getString("format.find", "&e{PLAYER} &ais playing on &e{SERVER}");
            Messages.MESSAGE = config.getString("format.message", "&a({SERVER}) &7[{SENDER} » {RECIPIENT}] &f{MESSAGE}");
            Messages.SEND = config.getString("format.send", "&aSending &e{PLAYER} &ato server &e{SERVER}");
            Messages.GLIST_HEADER = config.getString("settings.glist.header", "&aServers:");
            Messages.GLIST_SERVER = config.getString("settings.glist.body", "&a- {SERVER} {DENSITY}");
            Messages.INVALID_ARGS = config.getString("errors.invalid", "&cInvalid arguments provided.");
            Messages.PLAYER_OFFLINE = config.getString("errors.offline", "&cSorry, that player is offline.");
            Messages.NO_PERMS = config.getString("errors.permissions", "&cYou do not have permission to do that.");
            Messages.NO_SLAP = config.getString("errors.slap", "&cYou are unworthy of slapping people.");
            CommandRegister[] arr$ = CommandRegister.values();
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                CommandRegister registering = arr$[i$];
                if(nope != null) {
                    if(nope.contains(registering.getName())) {
                        this.getProxy().getPluginManager().registerCommand(this, registering.getCommand());
                    } else {
                        this.getLogger().info("Skipping registration of command \"" + registering.getName() + "\" as specified by the config.");
                    }
                } else {
                    this.getProxy().getPluginManager().registerCommand(this, registering.getCommand());
                }
            }
        }

    }

    private void saveConfig() throws IOException {
        if(!this.getDataFolder().exists()) {
            this.getDataFolder().mkdir();
        }

        File file = new File(this.getDataFolder(), "config.yml");
        if(!file.exists()) {
            Files.copy(this.getResourceAsStream("config.yml"), file.toPath(), new CopyOption[0]);
        }

    }

    private Configuration loadConfig() throws IOException {
        return ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(this.getDataFolder(), "config.yml"));
    }
}
