package me.valkyrienyanko.inventoryRestore.configs;

import org.bukkit.entity.Player;

public class ConfigPlayer extends ConfigResource {
	public ConfigPlayer(ConfigManager cm) {
		super(cm);
	}
	
	public void set(String path, Player p) {
		super.setConfigResource(path);
		
		super.config.set(path + ".name", p.getName());
		super.config.set(path + ".allowflight", p.getAllowFlight());
		super.config.set(path + ".canpickupitems", p.getCanPickupItems());
		super.config.set(path + ".exp_levels", p.getExpToLevel());
		super.config.set(path + ".exp", p.getExp());
		
		ConfigLocation configLoc = new ConfigLocation(super.cm);
		configLoc.set(path + ".bed", p.getBedSpawnLocation());
		configLoc.set(path + ".compasstarget", p.getCompassTarget());
		
		ConfigInv configInv = new ConfigInv(super.cm);
		configInv.set(path + ".enderchest", p.getEnderChest());
		
		ConfigEquipment configEquip = new ConfigEquipment(super.cm);
		configEquip.set(path + ".equipment", p.getEquipment());
	}
	
	public Player get(String path) {
		return null;
	}
}
