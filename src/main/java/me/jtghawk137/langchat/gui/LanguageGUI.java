package me.jtghawk137.langchat.gui;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class LanguageGUI extends GUI
{

    private static Inventory inventory;

    public LanguageGUI(String title, int size)
    {
        super(title, size);
        inventory = super.getInventory();
        String[] lore = {"§Spanish"};
        super.addItem(Material.WOOL, 0, "Spanish", Arrays.asList(lore));
    }

    public static Inventory getInv()
    {
        return inventory;
    }

}
