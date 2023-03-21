package me.regret.rHub.listeners;

import me.regret.rperms.main.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class tabListener implements Listener {

    private final Ranks ranks;
    public tabListener(Ranks ranks) {
        this.ranks = ranks;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(Bukkit.getServer().getPluginManager().getPlugin("rPerms").getConfig().
                getString("Players." + p.getUniqueId().toString() + ".rank") != null){
            String rank = ranks.getRank(p);
            String prefix = ranks.getRankPrefix(rank);
            p.setPlayerListName(prefix + p.getName());
        } else {
            p.setPlayerListName(p.getName());
        }
    }
}
