package me.jtghawk137.langchat.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class ProficiencyGUI
{

    private static Inventory inventory;

    /*
     * Not currently being used but may be in the future.
     */
    public ProficiencyGUI()
    {
        inventory = Bukkit.createInventory(null, 9, "Language Proficiency");
        String[] lore = {"§fBreakthrough or beginner"};
        InventoryUtils.addItem(inventory, Material.COAL, 1, "§bA1", Arrays.asList(lore));
        String[] lore2 = {"§fWaystage or elementary"};
        InventoryUtils.addItem(inventory, Material.REDSTONE, 2, "§bA2", Arrays.asList(lore2));
        String[] lore3 = {"§fThreshold or intermediate"};
        InventoryUtils.addItem(inventory, Material.IRON_INGOT, 3, "§bB1", Arrays.asList(lore3));
        String[] lore4 = {"§fVantage or upper intermediate"};
        InventoryUtils.addItem(inventory, Material.GOLD_INGOT, 4, "§bB2", Arrays.asList(lore4));
        String[] lore5 = {"§fEffective operational proficiency or", "§fadvanced"};
        InventoryUtils.addItem(inventory, Material.DIAMOND, 5, "§bC1", Arrays.asList(lore5));
        String[] lore6 = {"§fMastery or proficiency"};
        InventoryUtils.addItem(inventory, Material.EMERALD, 6, "§bC2", Arrays.asList(lore6));
        String[] lore7 = {"§fMother tongue"};
        InventoryUtils.addItem(inventory, Material.QUARTZ, 8, "§bNative", Arrays.asList(lore7));
    }

    public static Inventory getInv()
    {
        return inventory;
    }

}
