package me.jtghawk137.langchat.gui;

import com.google.common.collect.Maps;
import org.bukkit.inventory.Inventory;

import java.util.Map;

public class GUIRegister
{

    private static Map<String, Inventory> guis = Maps.newHashMap();

    public static Map<String, Inventory> getGUIs()
    {
        return guis;
    }

    public void registerGUIs()
    {
        guis.put("LangSelect", new LanguageGUI("name", 9).getInventory());
    }
}
