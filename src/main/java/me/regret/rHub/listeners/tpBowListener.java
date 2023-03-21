package me.regret.rHub.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class tpBowListener implements Listener {

    @EventHandler
    public void bow(ProjectileHitEvent e){
        if(e.getEntity() instanceof Arrow){
            Player p = (Player) e.getEntity().getShooter();

            float yaw = p.getLocation().getYaw();
            float pitch = p.getLocation().getPitch();

            Location loc = e.getEntity().getLocation();
            loc.setYaw(yaw);
            loc.setPitch(pitch);

            p.teleport(loc);
            e.getEntity().remove();
        }
    }
}
