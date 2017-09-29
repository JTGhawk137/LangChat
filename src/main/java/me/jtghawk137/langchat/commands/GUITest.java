package me.jtghawk137.langchat.commands;

import me.jtghawk137.langchat.gui.LanguageGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GUITest implements CommandExecutor
{

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings)
    {
        if (commandSender instanceof Player)
        {
            Player player = (Player) commandSender;
            player.openInventory(LanguageGUI.getInv());
        }
        return false;
    }
}
