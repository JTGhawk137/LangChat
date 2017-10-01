package me.jtghawk137.langchat.commands;

import me.jtghawk137.langchat.LangChat;
import me.jtghawk137.langchat.config.FileManager;
import me.jtghawk137.langchat.mysql.MySQLSetterGetter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class LangCommand implements CommandExecutor
{

    private MySQLSetterGetter setter = new MySQLSetterGetter();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args)
    {
        if (!(commandSender instanceof Player))
            return true;
        Player player = (Player) commandSender;

        if (args.length == 0)
        {
            player.sendMessage("§7Usage§c: §7/lang add; remove; change; see; info");
            return true;
        }
        /**
         * Add a language
         */
        if (args[0].equalsIgnoreCase("add"))
        {
            String pLanguage = null;
            String proficiency;

            if (args.length != 3)
            {
                player.sendMessage("§7Usage§c: §7/lang add <language that you're learning> <Proficiency (A1 - Native)");
                return true;
            }
            if (FileManager.get("languages.yml").getList("Languages").contains(args[1]))
                pLanguage = args[1];
            else
            {
                player.sendMessage("§cPlease enter a valid language");
            }
            if (!args[2].matches("(?i)A1|A2|B1|B2|C1|C2|Native"))
            {
                player.sendMessage("§cPlease enter a valid proficiency level");
                return true;
            }
            proficiency = args[2].toUpperCase();
            setter.addLanguage(player, player.getUniqueId(), pLanguage, proficiency);
        }
        /**
         * Remove a language
         */
        if (args[0].equalsIgnoreCase("remove"))
        {
            String pLanguage;

            if (args.length != 2)
            {
                player.sendMessage("§7Usage§c: §7/lang remove <language that you're done learning>");
                return true;
            }
            if (FileManager.get("languages.yml").getList("Languages").contains(args[1]))
            {
                pLanguage = args[1];
                setter.removeLanguage(player.getUniqueId(), pLanguage);
                player.sendMessage("§f" + pLanguage + " §ahas been removed.");
            } else
            {
                player.sendMessage("§cPlease enter a valid language");
                return true;
            }
        }
        /**
         * Change a language
         */
        if (args[0].equalsIgnoreCase("change"))
        {
            String pLanguage = null;
            String proficiency;

            if (args.length != 3)
            {
                player.sendMessage("§7Usage§c: §7/lang change <language that you're changing> <new proficiency>");
                return true;
            }
            if (FileManager.get("languages.yml").getList("Languages").contains(args[1]))
                pLanguage = args[1];
            else
            {
                player.sendMessage("§cPlease enter a valid language");
            }
            if (!args[2].matches("(?i)A1|A2|B1|B2|C1|C2|Native"))
            {
                player.sendMessage("§cPlease enter a valid proficiency level");
                return true;
            }
            proficiency = args[2];
            setter.changeLanguage(player.getUniqueId(), pLanguage, proficiency);
            player.sendMessage("§f" + pLanguage + " §ahas been changed to a proficiency of§f " + proficiency.toUpperCase() + "§a!");
        }
        /**
         * See others languages
         */
        if (args[0].equalsIgnoreCase("see"))
        {
            if (args.length != 2)
            {
                player.sendMessage("§7Usage§c: §7/lang see <player name>");
                return true;
            }
            for (Player p : Bukkit.getOnlinePlayers())
            {
                if (args[1].equalsIgnoreCase(p.getName()))
                {
                    Map<String, String> langs = setter.getLanguages(p.getUniqueId());
                    player.sendMessage("§aPlayer: §f" + p.getName());
                    if (langs.isEmpty())
                    {
                        player.sendMessage("§cNo languages found for this user.");
                    }
                    for (Map.Entry<String, String> e : langs.entrySet())
                    {
                        player.sendMessage("§b" + e.getKey() + " §7-§f " + e.getValue());
                    }
                }
            }
        }
        /**
         * Info about the plugin
         */
        if (args[0].equalsIgnoreCase("info"))
        {
            player.sendMessage("§bLangChat");
            player.sendMessage("§aAuthor: §fJTGhawk137");
            player.sendMessage("§aVersion §f" + LangChat.getInstance().getVersion());
            player.sendMessage("§aDescription: §fA plugin made to help people learn language through Minecraft");
        }
        return true;
    }
}