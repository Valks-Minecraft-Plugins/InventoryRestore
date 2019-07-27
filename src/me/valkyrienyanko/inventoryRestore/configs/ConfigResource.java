package me.valkyrienyanko.inventoryRestore.configs;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigResource {
	protected ConfigManager cm;
	protected YamlConfiguration config;

	public ConfigResource(ConfigManager cm) {
		this.cm = cm;
		this.config = cm.getConfig();
	}
	
	public String getPathParent(String path) {
		String[] items = path.split("\\.");
		String newPath = "";
		int uncutElements = items.length - 1;
		for (int i = 0; i < uncutElements; i++) {
			newPath += items[i] + (i == uncutElements - 1 ? "" : ".");
		}
		return newPath;
	}
	
	protected void setConfigResource(String path) {
		config.set(path, null);
	}
}
