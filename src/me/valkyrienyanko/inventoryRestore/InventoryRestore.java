package me.valkyrienyanko.inventoryRestore;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.valkyrienyanko.inventoryRestore.commands.RestoreInvCmd;
import me.valkyrienyanko.inventoryRestore.listeners.PlayerDeath;

public class InventoryRestore extends JavaPlugin {
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerDeath(), this);
		
		registerCommands();
	}
	
	private void registerCommands() {
		getCommand("invrestore").setExecutor(new RestoreInvCmd());
	}
}
