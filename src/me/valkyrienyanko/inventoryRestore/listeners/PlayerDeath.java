package me.valkyrienyanko.inventoryRestore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import me.valkyrienyanko.inventoryRestore.InventoryRestore;
import me.valkyrienyanko.inventoryRestore.configs.ConfigInv;
import me.valkyrienyanko.inventoryRestore.configs.ConfigManager;

public class PlayerDeath implements Listener {
	@EventHandler
	private void playerDeath(PlayerDeathEvent e) {
		ConfigManager cm = new ConfigManager(JavaPlugin.getPlugin(InventoryRestore.class), "players");
		ConfigInv ci = new ConfigInv(cm);
		ci.set(e.getEntity().getUniqueId().toString(), e.getEntity().getInventory());
		cm.saveConfig();
	}
}
