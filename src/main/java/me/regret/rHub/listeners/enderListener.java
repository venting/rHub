package me.regret.rHub.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class enderListener implements Listener {

    @EventHandler
    public void onProjectileThrow(ProjectileLaunchEvent event) {
        if (event.getEntity() instanceof EnderPearl && event.getEntity().getShooter() instanceof Player) {
            event.getEntity().setPassenger((Entity) event.getEntity().getShooter());
        }
    }

    @EventHandler
    public void onProjectileHitEvent (ProjectileHitEvent e){
        if (e.getEntity().getShooter() instanceof Player){
            if (e.getEntity() instanceof EnderPearl){
                Player p = (Player) e.getEntity().getShooter();
                ItemStack epearl = new ItemStack(Material.ENDER_PEARL);
                ItemMeta epearlmeta = epearl.getItemMeta();
                epearlmeta.setDisplayName("§eEnderbutt");
                epearl.setItemMeta(epearlmeta);

                p.getInventory().setItem(8, epearl);

            }
        }
    }
}
