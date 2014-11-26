package me.Hugmanrique.EssentialsBungee;

/**
 * Created by Hugo on 26/11/2014.
 */
import net.md_5.bungee.api.ChatColor;

public class Messages {

    public static String ALERT = "&8[&a+&8] &7{ALERT}";
    public static String FIND = "&d&l[Info] &e{PLAYER} &festá jugando en el Servidor &e{SERVER}";
    public static String GLIST_HEADER = "&d&l[Info] &eServidores:";
    public static String GLIST_SERVER = "&f- &e{SERVER} &7{DENSITY}";
    public static String INVALID_ARGS = "&c&l[Error] &fArgumentos no válidos.";
    public static String MESSAGE = "&a&l[MSG] &e{SENDER} &f(&e{SERVER}&f) &a&l>> &e{RECIPIENT}&f: {MESSAGE}";
    public static String PLAYER_OFFLINE = "&c&l[Error] &fEse Jugador no está dentro de el Servidor.";
    public static String NO_PERMS = "&c&l[Error] &fNo tienes Rango suficiente para hacer eso.";
    public static String NO_SLAP = "&c&l[Error] &fNo mereces Slapear a Gente.";
    public static String SEND = "&5&l[ADMIN] &fMandando a &e{PLAYER} &fal Servidor &e{SERVER}";


    public static String lazyColour(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static String combine(String[] array) {
        StringBuilder builder = new StringBuilder();
        String[] arr$ = array;
        int len$ = array.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String string = arr$[i$];
            builder.append(string);
            if(!string.equals(array[array.length - 1])) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    public static String combine(int omit, String[] array) {
        StringBuilder builder = new StringBuilder();
        String[] arr$ = array;
        int len$ = array.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String string = arr$[i$];
            if(string != array[omit]) {
                builder.append(string);
                if(!string.equals(array[array.length - 1])) {
                    builder.append(" ");
                }
            }
        }

        return builder.toString();
    }

}
