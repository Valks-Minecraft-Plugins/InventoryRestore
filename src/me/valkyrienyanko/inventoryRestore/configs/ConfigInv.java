package me.valkyrienyanko.inventoryRestore.configs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ConfigInv extends ConfigResource {
	public ConfigInv(ConfigManager config) {
		super(config);
	}
	
	public void set(String path, Inventory inv) {
		super.setConfigResource(path);
		super.config.set(path + ".title", inv.getType().getDefaultTitle()); // <-- Weird way of getting the inventory title?
		super.config.set(path + ".size", inv.getSize());
		
		int slot = 0;
		for (ItemStack item : inv.getContents()) {
			ConfigItem configItem = new ConfigItem(super.cm);
			if (item != null) {
				configItem.set(path + ".contents." + slot, item);
			}
			slot++;
		}
		
		//TODO INVENTORY HOLDER
	}
	
	public Inventory get(String path) {
		String title = super.config.getString(path + ".title");
		int size = super.config.getInt(path + ".size");
		
		Inventory inv = Bukkit.createInventory(null, size, title);
		
		ConfigurationSection contents = super.config.getConfigurationSection(path + ".contents");
		for (String slotString : contents.getKeys(false)) {
			int slot = Integer.parseInt(slotString);
			ConfigItem configItem = new ConfigItem(super.cm);
			ItemStack item = configItem.get(path + ".contents." + slot);
			inv.setItem(slot, item);
		}
		
		return inv;
	}
}
