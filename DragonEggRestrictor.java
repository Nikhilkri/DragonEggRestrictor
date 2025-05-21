package com.overscarf.dragoneggrestrictor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class DragonEggRestrictor extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getWhoClicked().hasPermission("dragoneggrestrictor.bypass")) return;
        
        ItemStack item = event.getCurrentItem();
        if (item == null || item.getType() != Material.DRAGON_EGG) return;

        Inventory inv = event.getInventory();
        if (inv.getType() == Inventory.Type.ENDER_CHEST || 
            inv.getType() == Inventory.Type.SHULKER_BOX) {
            event.setCancelled(true);
            event.getWhoClicked().sendMessage("§cYou cannot store dragon eggs here!");
        }
    }
}
