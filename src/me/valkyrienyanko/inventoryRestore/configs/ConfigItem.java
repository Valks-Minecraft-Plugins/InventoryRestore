package me.valkyrienyanko.inventoryRestore.configs;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ConfigItem extends ConfigResource {
	public ConfigItem(ConfigManager config) {
		super(config);
	}
	
	public void set(String path, ItemStack item) {
		super.setConfigResource(path);
		
		ItemMeta im = item.getItemMeta();
		
		String name = null;
		List<String> lore = null;
		
		int quantity = item.getAmount();
		
		List<String> flags = new ArrayList<String>();
		
		if (im != null) {
			name = im.getDisplayName();
			lore = im.getLore();
			
			for (ItemFlag flag : im.getItemFlags())
				flags.add(flag.name());
		}
		
		super.config.set(path + ".material", item.getType().name());
		if (name != null && name != "")
			super.config.set(path + ".name", name);
		if (quantity != 1)
			super.config.set(path + ".quantity", quantity);
		if (lore != null)
			super.config.set(path + ".lore", lore);
		if (flags.size() != 0)
			super.config.set(path + ".flags", flags);
	}

	public ItemStack get(String path) {
		String materialName = super.config.getString(path + ".material");
		String itemName = super.config.getString(path + ".name");
		List<String> configLore = super.config.getStringList(path + ".lore");
		List<String> formattedLore = new ArrayList<String>();
		List<String> itemFlags = super.config.getStringList(path + ".flags");
		int quantity = super.config.getInt(path + ".quantity");

		if (!super.config.isSet(path + ".quantity"))
			quantity = 1;

		Material material = null;

		try {
			material = Material.valueOf(materialName);
		} catch (IllegalArgumentException e) {
			//Utils.sendError(e, "You made a type error! " + e.getMessage());
			material = Material.AIR;
		}

		if (itemName == null) {
			itemName = "";
			String[] words = material.name().toLowerCase().split("_");
			for (int i = 0; i < words.length; i++) {
				itemName += words[i].substring(0, 1).toUpperCase() + words[i].substring(1)
						+ (i == words.length - 1 ? "" : " ");
			}
		}

		ItemStack item = new ItemStack(material, quantity);
		ItemMeta im = item.getItemMeta();

		if (im != null) {
			im.setDisplayName(itemName);
			if (configLore != null) {
				for (String element : configLore)
					formattedLore.add(element);
				im.setLore(formattedLore);
			}

			if (itemFlags != null) {
				for (String element : itemFlags) {
					im.addItemFlags(ItemFlag.valueOf(element.toUpperCase()));
				}
			}

			item.setItemMeta(im);
		}

		return item;
	}
}
