package me.jtghawk137.langchat;

import me.jtghawk137.langchat.commands.CommandRegister;
import me.jtghawk137.langchat.config.FileManager;
import me.jtghawk137.langchat.events.EventRegister;
import me.jtghawk137.langchat.mysql.MySQLConnection;
import me.jtghawk137.langchat.mysql.MySQLSetterGetter;
import org.bukkit.plugin.java.JavaPlugin;

public class LangChat extends JavaPlugin
{

    private static LangChat instance;
    private EventRegister eventRegister = new EventRegister();
    private CommandRegister commandRegister = new CommandRegister();
    private MySQLConnection connection = new MySQLConnection();
    private MySQLSetterGetter setter;
    private String version = getDescription().getVersion();

    public static LangChat getInstance()
    {
        return instance;
    }

    @Override
    public void onEnable()
    {
        instance = this;
        eventRegister.registerEvents();
        commandRegister.registerCommands();
        FileManager.loadConfigs();
        connection.mysqlSetup();
        setter = new MySQLSetterGetter();
    }

    @Override
    public void onDisable()
    {
        instance = null;
    }

    public String getVersion()
    {
        return version;
    }

    public MySQLConnection getConnection()
    {
        return connection;
    }
}
