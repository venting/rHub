package me.regret.rHub.listeners;

import me.regret.rperms.main.Ranks;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class armorListener implements Listener {

    private final me.regret.rperms.main.Ranks Ranks;
    public armorListener(Ranks Ranks) {
        this.Ranks = Ranks;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        //ARMOR
        if(Bukkit.getServer().getPluginManager().getPlugin("rPerms").getConfig().
                getString("Players." + p.getUniqueId().toString() + ".rank") != null){
            String rank = Ranks.getRank(p);
            if(rank.equalsIgnoreCase("owner")){
                ItemStack ownerH = new ItemStack(Material.GLASS);
                LeatherArmorMeta meta = (LeatherArmorMeta) ownerH.getItemMeta();
                meta.setDisplayName("§6f");
                ownerH.setItemMeta(meta);

                ItemStack ownerC = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metaC = (LeatherArmorMeta) ownerH.getItemMeta();
                metaC.setColor(Color.RED);
                meta.setDisplayName("§6f");
                ownerC.setItemMeta(metaC);

                ItemStack ownerL = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metaL = (LeatherArmorMeta) ownerH.getItemMeta();
                metaL.setColor(Color.RED);
                meta.setDisplayName("§6f");
                ownerL.setItemMeta(metaL);

                ItemStack ownerB = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metaB = (LeatherArmorMeta) ownerH.getItemMeta();
                metaB.setColor(Color.RED);
                meta.setDisplayName("§6f");
                ownerB.setItemMeta(metaB);

                p.getInventory().setHelmet(ownerH);
                p.getInventory().setChestplate(ownerC);
                p.getInventory().setLeggings(ownerL);
                p.getInventory().setBoots(ownerB);
            }
            if(rank.equalsIgnoreCase("admin") || rank.equalsIgnoreCase("manager")){
                ItemStack adminH = new ItemStack(Material.GLASS);
                LeatherArmorMeta meta = (LeatherArmorMeta) adminH.getItemMeta();
                meta.setDisplayName("§6f");
                adminH.setItemMeta(meta);

                ItemStack adminC = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metaC = (LeatherArmorMeta) adminH.getItemMeta();
                metaC.setColor(Color.ORANGE);
                meta.setDisplayName("§6f");
                adminC.setItemMeta(metaC);

                ItemStack adminL = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metaL = (LeatherArmorMeta) adminH.getItemMeta();
                metaL.setColor(Color.ORANGE);
                meta.setDisplayName("§6f");
                adminL.setItemMeta(metaL);

                ItemStack adminB = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metaB = (LeatherArmorMeta) adminH.getItemMeta();
                metaB.setColor(Color.ORANGE);
                meta.setDisplayName("§6f");
                adminB.setItemMeta(metaB);

                p.getInventory().setHelmet(adminH);
                p.getInventory().setChestplate(adminC);
                p.getInventory().setLeggings(adminL);
                p.getInventory().setBoots(adminB);
            }
            if(rank.equalsIgnoreCase("developer")){
                ItemStack devH = new ItemStack(Material.GLASS);
                LeatherArmorMeta meta = (LeatherArmorMeta) devH.getItemMeta();
                meta.setDisplayName("§6f");
                devH.setItemMeta(meta);

                ItemStack devC = new ItemStack(Material.LEATHER_CHESTPLATE);
                LeatherArmorMeta metaC = (LeatherArmorMeta) devH.getItemMeta();
                metaC.setColor(Color.BLUE);
                meta.setDisplayName("§6f");
                devC.setItemMeta(metaC);

                ItemStack devL = new ItemStack(Material.LEATHER_LEGGINGS);
                LeatherArmorMeta metaL = (LeatherArmorMeta) devH.getItemMeta();
                metaL.setColor(Color.BLUE);
                meta.setDisplayName("§6f");
                devL.setItemMeta(metaL);

                ItemStack devB = new ItemStack(Material.LEATHER_BOOTS);
                LeatherArmorMeta metaB = (LeatherArmorMeta) devH.getItemMeta();
                metaB.setColor(Color.BLUE);
                meta.setDisplayName("§6f");
                devB.setItemMeta(metaB);

                p.getInventory().setHelmet(devH);
                p.getInventory().setChestplate(devC);
                p.getInventory().setLeggings(devL);
                p.getInventory().setBoots(devB);
            }
        } else {
            p.getInventory().setHelmet(new ItemStack(Material.GLASS));
        }
    }

    @EventHandler
    public void invClick(InventoryClickEvent e){
        if(e.getCurrentItem().getType().equals(Material.LEATHER_BOOTS)){
            e.setCancelled(true);
        }
        if(e.getCurrentItem().getType().equals(Material.LEATHER_LEGGINGS)){
            e.setCancelled(true);
        }
        if(e.getCurrentItem().getType().equals(Material.LEATHER_CHESTPLATE)){
            e.setCancelled(true);
        }
        if(e.getCurrentItem().getType().equals(Material.GLASS)){
            e.setCancelled(true);
        }
        if(e.getCurrentItem().getType().equals(Material.BOW)){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dTeleport Bow")){
                e.setCancelled(true);
            }
        }
        if(e.getCurrentItem().getType().equals(Material.COMPASS)){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dServer Selector")){
                e.setCancelled(true);
            }
        }
        if(e.getCurrentItem().getType().equals(Material.ENDER_PEARL)){
            e.setCancelled(true);

        }
        if(e.getCurrentItem().getType().equals(Material.ARROW)){
                e.setCancelled(true);

        }
    }
    @EventHandler
    public void drop(PlayerDropItemEvent e){
        if(e.getItemDrop().equals(Material.BOW)){
            if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§dTeleport Bow")){
                e.setCancelled(true);
            }
        }
        if(e.getItemDrop().equals(Material.COMPASS)){
            if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§dServer Selector")){
                e.setCancelled(true);
            }
        }
        if(e.getItemDrop().equals(Material.ENDER_PEARL)){
            if(e.getItemDrop().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase("§dEnderbutt")){
                e.setCancelled(true);
            }
        }
        if(e.getItemDrop().equals(Material.ARROW)){
            e.setCancelled(true);
        }
    }
}

