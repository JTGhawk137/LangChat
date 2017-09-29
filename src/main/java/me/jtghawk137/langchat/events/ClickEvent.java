package me.jtghawk137.langchat.events;

import me.jtghawk137.langchat.gui.GUIRegister;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener
{

    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        String name = e.getInventory().getName();
        for (String n : GUIRegister.getGUIs().keySet())
        {
            if (name.equals(GUIRegister.getGUIs().get(n).getName()))
                e.setCancelled(true);
        }
    }
}
