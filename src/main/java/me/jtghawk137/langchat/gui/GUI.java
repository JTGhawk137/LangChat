package me.jtghawk137.langchat.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class GUI
{

    private Inventory inventory;
    private String title;
    private int size;

    public GUI(String title, int size)
    {
        inventory = Bukkit.createInventory(null, size, title);
        this.title = title;
        this.size = size;
    }

    public void addItem(Material material, int amount, String name, List<String> lore)
    {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        stack.setItemMeta(meta);
        inventory.setItem(amount, stack);
    }

    public Inventory getInventory()
    {
        return inventory;
    }
}
