package me.valkyrienyanko.inventoryRestore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import me.valkyrienyanko.inventoryRestore.InventoryRestore;
import me.valkyrienyanko.inventoryRestore.configs.ConfigInv;
import me.valkyrienyanko.inventoryRestore.configs.ConfigManager;

public class RestoreInvCmd implements CommandExecutor {
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!cmd.getName().equalsIgnoreCase("invrestore")) return false;
		if (args.length == 0) return false;
		if (!sender.isOp()) return false;
		Player target = Bukkit.getPlayer(args[0]);
		if (target == null) {
			sender.sendMessage("That player is not online / doesn't exist.");
			return false;
		}
		ConfigManager cm = new ConfigManager(JavaPlugin.getPlugin(InventoryRestore.class), "players");
		ConfigInv ci = new ConfigInv(cm);
		Inventory deathInv = ci.get(target.getUniqueId().toString());
		Inventory targetInv = target.getInventory();
		targetInv.setContents(deathInv.getContents());
		sender.sendMessage("Recovered " + target.getDisplayName() + "'s inventory.");
		target.sendMessage("Your inventory was recovered by " + sender.getName() + ".");
		return false;
	}
}
