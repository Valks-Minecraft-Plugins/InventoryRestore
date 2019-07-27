package me.valkyrienyanko.inventoryRestore.configs;

import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import me.valkyrienyanko.inventoryRestore.customTypes.CustomEntityEquipment;

public class ConfigEquipment extends ConfigResource {
	public ConfigEquipment(ConfigManager cm) {
		super(cm);
	}
	
	public void set(String path, EntityEquipment equip) {
		super.setConfigResource(path);
		
		ConfigItem configItem = new ConfigItem(super.cm);
		
		ItemStack helmet = equip.getHelmet();
		ItemStack chestplate = equip.getChestplate();
		ItemStack leggings = equip.getLeggings();
		ItemStack boots = equip.getBoots();
		ItemStack mainhand = equip.getItemInHand();
		
		if (helmet != null) {
			configItem.set(path + ".helmet", helmet);
			super.config.set(path + ".helmet.dropchance", equip.getHelmetDropChance());
		}
		
		if (chestplate != null) {
			configItem.set(path + ".chestplate", equip.getChestplate());
			super.config.set(path + ".chestplate.dropchance", equip.getChestplateDropChance());
		}
		
		if (leggings != null) {
			configItem.set(path + ".leggings", equip.getLeggings());
			super.config.set(path + ".leggings.dropchance", equip.getLeggingsDropChance());
		}
		
		if (boots != null) {
			configItem.set(path + ".boots", equip.getBoots());
			super.config.set(path + ".boots.dropchance", equip.getBootsDropChance());
		}
		
		if (mainhand != null) {
			configItem.set(path + ".mainhand", equip.getItemInHand());
			super.config.set(path + ".mainhand.dropchance", equip.getItemInHandDropChance());
		}
	}
	
	public CustomEntityEquipment get(String path) {
		CustomEntityEquipment equip = new CustomEntityEquipment();
		ConfigItem configItem = new ConfigItem(super.cm);
		equip.setHelmet(configItem.get(path + ".helmet"));
		equip.setChestplate(configItem.get(path + ".chestplate"));
		equip.setLeggings(configItem.get(path + ".leggings"));
		equip.setBoots(configItem.get(path + ".boots"));
		equip.setMainHand(configItem.get(path + ".mainhand"));
		equip.setOffHand(configItem.get(path + ".offhand"));
		equip.setHelmetDropChance((float) super.config.getDouble(path + ".helmet.dropchance"));
		equip.setChestplateDropChance((float) super.config.getDouble(path + ".chestplate.dropchance"));
		equip.setLeggingsDropChance((float) super.config.getDouble(path + ".leggings.dropchance"));
		equip.setBootsDropChance((float) super.config.getDouble(path + ".boots.dropchance"));
		equip.setMainHandDropChance((float) super.config.getDouble(path + ".mainhand.dropchance"));
		return equip;
	}
}
