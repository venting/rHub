package me.regret.rHub.listeners;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class serverListener implements Listener {

    @EventHandler
    public void DoubleJump(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
            Block b = p.getWorld().getBlockAt(p.getLocation().subtract(0,2,0));
            Vector v = p.getLocation().getDirection().multiply(1).setY(1);
            p.setVelocity(v);
            p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 5, 10);
            World w = p.getWorld();
            Location l = p.getLocation();
            l.setY(l.getY() - 2);
            w.playEffect(l, Effect.SNOWBALL_BREAK, 1);
            w.playEffect(l, Effect.SNOWBALL_BREAK, 2);
            w.playEffect(l, Effect.SNOWBALL_BREAK, 3);
            w.playEffect(l, Effect.SNOWBALL_BREAK, 4);
            w.playEffect(l, Effect.SNOWBALL_BREAK, 5);
            if (b.getType() == Material.AIR) {
                Vector v1 = p.getLocation().getDirection().multiply(1.25).setY(0.5);
                p.setVelocity(v1);
                p.playSound(p.getLocation(), Sound.BLAZE_HIT, 5, 10); {
                    l.setY(l.getY() - 2);
                    w.playEffect(l, Effect.CLOUD, 1);
                    w.playEffect(l, Effect.CLOUD, 2);
                    w.playEffect(l, Effect.CLOUD, 3);
                    w.playEffect(l, Effect.CLOUD, 4);
                    w.playEffect(l, Effect.CLOUD, 5);

                }
            }
        }
    }

    //ITEMS
    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action a = e.getAction();
        if (e.getAction() != null) {
            if (p.getInventory().getItemInHand() != null) {
                if (p.getInventory().getItemInHand().getItemMeta() != null) {
                    if (a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK)) {
                        if (p.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("§dServer Selector")) {
                            p.performCommand("server");
                        }
                    }
                }
            }
        }
    }

    //INVENTORY
    @EventHandler
    public void invClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() != null) {
            if (e.getInventory().getTitle().contains("Server Selector")) {
                if (e.getCurrentItem().getItemMeta() != null) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§ePractice")){
                            p.performCommand("server practice");
                            p.closeInventory();
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}
