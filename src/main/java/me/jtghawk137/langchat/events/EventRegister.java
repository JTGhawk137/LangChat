package me.jtghawk137.langchat.events;

import com.google.common.collect.Lists;
import me.jtghawk137.langchat.LangChat;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class EventRegister
{

    private ArrayList<? extends Listener> events = Lists.newArrayList();

    public void registerEvents()
    {
        LangChat.getInstance().getServer().getPluginManager().registerEvents(new ClickEvent(), LangChat.getInstance());
        LangChat.getInstance().getServer().getPluginManager().registerEvents(new CommandEvent(), LangChat.getInstance());
    }
}
