package me.Hugmanrique.EssentialsBungee.commands;

/**
 * Created by Hugo on 26/11/2014.
 */
import me.Hugmanrique.EssentialsBungee.commands.Dispatch;
import me.Hugmanrique.EssentialsBungee.commands.ServerList;
import me.Hugmanrique.EssentialsBungee.commands.Message;
import me.Hugmanrique.EssentialsBungee.commands.Reply;
import me.Hugmanrique.EssentialsBungee.commands.Search;
import me.Hugmanrique.EssentialsBungee.commands.Slap;
import net.md_5.bungee.api.plugin.Command;

public enum CommandRegister {

    DISPATCH("DISPATCH", 1, "dispatch", new Dispatch()),
    SEARCH("SEARCH", 2, "search", new Search()),
    LIST("LIST", 3, "list", new ServerList()),
    MESSAGE("MESSAGE", 4, "message", new Message()),
    REPLY("REPLY", 5, "message", new Reply()),
    SLAP("SLAP", 6, "slap", new Slap());
    private final Command command;
    private final String name;
    // $FF: synthetic field
    private static final CommandRegister[] $VALUES = new CommandRegister[]{DISPATCH, SEARCH, LIST, MESSAGE, REPLY, SLAP};


    private CommandRegister(String var1, int var2, String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public Command getCommand() {
        return this.command;
    }

    public String getName() {
        return this.name;
    }

}
