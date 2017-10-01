package me.jtghawk137.langchat.commands;

import com.google.common.collect.Lists;
import me.jtghawk137.langchat.LangChat;
import org.bukkit.command.CommandExecutor;

import java.util.ArrayList;

public class CommandRegister
{

    private ArrayList<? extends CommandExecutor> commands = Lists.newArrayList();

    public void registerCommands()
    {
        LangChat.getInstance().getCommand("lang").setExecutor(new LangCommand());
    }
}
