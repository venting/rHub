package me.regret.rHub;

import me.regret.rHub.commands.serverCommand;
import me.regret.rHub.listeners.*;
import me.regret.rHub.listeners.connectListener;
import org.bukkit.plugin.java.JavaPlugin;
import me.regret.rHub.scoreboard.Scoreboard;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //COMMANDS
        getCommand("Server").setExecutor(new serverCommand());
        //LISTENERS
        getServer().getPluginManager().registerEvents(new tabListener(), this);
        getServer().getPluginManager().registerEvents(new enderListener(), this);
        getServer().getPluginManager().registerEvents(new tpBowListener(), this);
        getServer().getPluginManager().registerEvents(new connectListener(), this);
        getServer().getPluginManager().registerEvents(new disconnectListener(), this);
        getServer().getPluginManager().registerEvents(new serverListener(), this);
        getServer().getPluginManager().registerEvents(new playerListener(), this);
        getServer().getPluginManager().registerEvents(new armorListener(), this);
        getServer().getPluginManager().registerEvents(new Scoreboard(this), this);
    }
    @Override
    public void onDisable() {
        saveConfig();
        saveDefaultConfig();
    }
}
