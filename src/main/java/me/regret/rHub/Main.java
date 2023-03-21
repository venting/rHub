package me.regret.rHub;

import me.regret.rHub.commands.serverCommand;
import me.regret.rHub.listeners.*;
import me.regret.rHub.listeners.connectListener;
import me.regret.rPerms.Ranks;
import org.bukkit.plugin.java.JavaPlugin;
import me.regret.rHub.scoreboard.Scoreboard;

public class Main extends JavaPlugin {

    private Ranks Ranks;

    @Override
    public void onEnable() {
        //COMMANDS
        getCommand("Server").setExecutor(new serverCommand());
        //LISTENERS
        getServer().getPluginManager().registerEvents(new tabListener(Ranks), this);
        getServer().getPluginManager().registerEvents(new enderListener(), this);
        getServer().getPluginManager().registerEvents(new tpBowListener(), this);
        getServer().getPluginManager().registerEvents(new connectListener(), this);
        getServer().getPluginManager().registerEvents(new disconnectListener(), this);
        getServer().getPluginManager().registerEvents(new serverListener(), this);
        getServer().getPluginManager().registerEvents(new playerListener(), this);
        getServer().getPluginManager().registerEvents(new armorListener(Ranks), this);
        getServer().getPluginManager().registerEvents(new Scoreboard(this, Ranks), this);
    }
    @Override
    public void onDisable() {
        saveConfig();
        saveDefaultConfig();
    }
}
