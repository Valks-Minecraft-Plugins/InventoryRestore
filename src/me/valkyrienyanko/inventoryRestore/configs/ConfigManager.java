package me.valkyrienyanko.inventoryRestore.configs;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigManager {
	private File file;
	private YamlConfiguration config;

	public ConfigManager(Plugin plugin, String name) {
		file = new File(plugin.getDataFolder(), name + ".yml");
		config = YamlConfiguration.loadConfiguration(file);
	}

	public void saveConfig() {
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void reloadConfig() {
		config = YamlConfiguration.loadConfiguration(file);
	}

	public YamlConfiguration getConfig() {
		return config;
	}
}
