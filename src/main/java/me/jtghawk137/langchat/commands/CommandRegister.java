package me.jtghawk137.langchat.commands;

import me.jtghawk137.langchat.LangChat;

public class CommandRegister
{
    public void registerCommands()
    {
        LangChat.getInstance().getCommand("lang").setExecutor(new LangCommand());
    }
}
