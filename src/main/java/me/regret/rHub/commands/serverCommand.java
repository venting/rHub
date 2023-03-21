package me.regret.rHub.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class serverCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        Inventory inv = Bukkit.createInventory(null, 9, "§dServer Selector");

        ItemStack selector = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta selectormeta = selector.getItemMeta();
        selectormeta.setDisplayName("§dPractice");
        selector.setItemMeta(selectormeta);
        
        inv.setItem(4, selector);
        p.openInventory(inv);
        return true;
    }
}
