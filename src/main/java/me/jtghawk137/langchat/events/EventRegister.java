package me.jtghawk137.langchat.events;

import me.jtghawk137.langchat.LangChat;

public class EventRegister
{

    public void registerEvents()
    {
        LangChat.getInstance().getServer().getPluginManager().registerEvents(new CommandEvent(), LangChat.getInstance());
    }
}
