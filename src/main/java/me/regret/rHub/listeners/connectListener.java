package me.regret.rHub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class connectListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.getInventory().clear();

        int onlineP = 0;
        for (final Player online : Bukkit.getServer().getOnlinePlayers()) {
            onlineP++;
        }
        p.sendMessage("§f§m--------------------------------------------------");
        p.sendMessage("§5§l                    Regret Network");
        p.sendMessage("");
        p.sendMessage("  §dWelcome " + p.getDisplayName() + "§d to the §5§lRegret Network§e!");
        p.sendMessage(new StringBuilder().append("§f§l • §dOnline: §r").append(onlineP).toString() + "§7/§f1,000");
        p.sendMessage("§f§m--------------------------------------------------");
        e.setJoinMessage("");

        //ITEMS
        ItemStack bow = new ItemStack(Material.BOW);
        bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 999);
        ItemMeta bowmeta = bow.getItemMeta();
        bowmeta.setDisplayName("§dTeleport Bow");
        bow.setItemMeta(bowmeta);

        ItemStack selector = new ItemStack(Material.COMPASS);
        ItemMeta selectormeta = selector.getItemMeta();
        selectormeta.setDisplayName("§dServer Selector");
        selector.setItemMeta(selectormeta);

        ItemStack epearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta epearlmeta = epearl.getItemMeta();
        epearlmeta.setDisplayName("§dEnderbutt");
        epearl.setItemMeta(epearlmeta);

        p.getInventory().setItem(0, bow);
        p.getInventory().setItem(4, selector);
        p.getInventory().setItem(8, epearl);
        p.getInventory().setItem(27, new ItemStack(Material.ARROW));
    }
}
