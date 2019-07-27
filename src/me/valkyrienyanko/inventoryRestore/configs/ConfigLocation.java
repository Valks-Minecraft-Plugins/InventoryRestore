package me.valkyrienyanko.inventoryRestore.configs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class ConfigLocation extends ConfigResource {
	public ConfigLocation(ConfigManager cm) {
		super(cm);
	}
	
	public void set(String path, Location loc) {
		super.setConfigResource(path);
		
		if (loc != null) {
			super.config.set(path + ".world", loc.getWorld().getName());
			super.config.set(path + ".x", loc.getX());
			super.config.set(path + ".y", loc.getY());
			super.config.set(path + ".z", loc.getZ());
			super.config.set(path + ".yaw", loc.getYaw());
			super.config.set(path + ".pitch", loc.getPitch());
		}
	}
	
	public Location get(String path) {
		World w = Bukkit.getWorld(super.config.getString(path + ".world"));
		double x = super.config.getDouble(path + ".x");
		double y = super.config.getDouble(path + ".y");
		double z = super.config.getDouble(path + ".z");
		float yaw = (float) super.config.getDouble(path + ".yaw");
		float pitch = (float) super.config.getDouble(path + ".pitch");
		return new Location(w, x, y, z, yaw, pitch);
	}
}
