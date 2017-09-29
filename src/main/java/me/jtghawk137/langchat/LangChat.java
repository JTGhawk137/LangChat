package me.jtghawk137.langchat;

import me.jtghawk137.langchat.commands.CommandRegister;
import me.jtghawk137.langchat.events.EventRegister;
import me.jtghawk137.langchat.gui.GUIRegister;
import org.bukkit.plugin.java.JavaPlugin;

public class LangChat extends JavaPlugin
{

    private static LangChat instance;
    private EventRegister eventRegister = new EventRegister();
    private CommandRegister commandRegister = new CommandRegister();
    private GUIRegister guiRegister = new GUIRegister();
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
        guiRegister.registerGUIs();
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
}
