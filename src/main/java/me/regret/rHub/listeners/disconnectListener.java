package me.regret.rHub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class disconnectListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        p.getInventory().getHelmet().setType(null);
        p.getInventory().getChestplate().setType(null);
        p.getInventory().getChestplate().setType(null);
        p.getInventory().getChestplate().setType(null);
    }
}
