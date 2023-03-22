package me.regret.rHub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class tabListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(Bukkit.getServer().getPluginManager().getPlugin("rPerms").getConfig().
                getString("Players." + p.getUniqueId().toString() + ".rank") != null){
            String rank = Bukkit.getServer().getPluginManager().getPlugin("rPerms").getConfig()
                    .getString("Players." + p.getUniqueId().toString() + ".rank");
            String prefix = Bukkit.getServer().getPluginManager().getPlugin("rPerms").getConfig()
                    .getString("Ranks." + rank + ".prefix");

            p.setPlayerListName(ChatColor.translateAlternateColorCodes('&', prefix) + " " + p.getName());
        } else {
            p.setPlayerListName(p.getName());
        }
    }
}
