package me.regret.rHub.scoreboard;

import me.regret.rHub.Main;
import me.regret.rPerms.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scoreboard implements Listener {
    //public Map<Player, Scoreboard> scores = new HashMap<Player, Scoreboard>();
    private final Main plugin;
    private final Ranks Ranks;
    public Scoreboard(Main plugin, Ranks Ranks) {
        this.plugin = plugin;
        this.Ranks = Ranks;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        scoreUtils Utils = scoreUtils.createScore(player);
        Utils.setTitle("&5&lRegret Network");
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                updateScoreboard(player);
            }
        }, 0L, 200L);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(scoreUtils.hasScore(player)) {
            scoreUtils.removeScore(player);
        }
    }
    public void updateScoreboard(Player player) {
        if(scoreUtils.hasScore(player)) {
            scoreUtils Utils = scoreUtils.getByPlayer(player);
            ArrayList<String> list = new ArrayList<>();
            int onlineP = 0;
            for (final Player online : Bukkit.getServer().getOnlinePlayers()) {
                onlineP++;
            }

            ConfigurationSection rankNames = Bukkit.getPluginManager().getPlugin("rPerms").getConfig().getConfigurationSection("Ranks");

            if (rankNames != null) {
                if(Ranks.getRank(player) == null){
                    list.add("&7&l&m------------------");
                    list.add("&dPlayers Online&7:");
                    list.add(new StringBuilder().append("&7&l* &r").append(onlineP).toString() + "&7/&f1,000");
                    list.add("");
                    list.add("&dRank&7: No Rank");
                    list.add(" ");
                    list.add("&7&ostore.regret.cc");
                    list.add("&7&l&m------------------");
                    Utils.setSlotsFromList(list);
                } else {
                    list.add("&7&l&m------------------");
                    list.add("&dPlayers Online&7:");
                    list.add(new StringBuilder().append("&7&l* &r").append(onlineP).toString() + "&7/&f1,000");
                    list.add("");
                    list.add("&dRank&7: " + Ranks.getRank(player));
                    list.add(" ");
                    list.add("&7&ostore.regret.cc");
                    list.add("&7&l&m------------------");
                    Utils.setSlotsFromList(list);
                }
            }
        }
    }
}

