package me.jtghawk137.langchat.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandEvent implements Listener
{

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e)
    {
        if (e.getMessage().equals("/plugins"))
        {
            e.setCancelled(true);
            e.getPlayer().sendMessage("§fPlugins (1): §aATWMC Custom Server");
        }
    }
}
