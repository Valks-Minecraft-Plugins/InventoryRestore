package me.valkyrienyanko.inventoryRestore.customTypes;

import org.bukkit.inventory.ItemStack;

public class CustomEntityEquipment {
	private ItemStack helmet;
	private ItemStack chestplate;
	private ItemStack leggings;
	private ItemStack boots;
	private ItemStack mainhand;
	private ItemStack offhand;
	
	private float helmetDropChance;
	private float chestplateDropChance;
	private float leggingsDropChance;
	private float bootsDropChance;
	private float mainhandDropChance;
	private float offhandDropChance;
	
	public CustomEntityEquipment() {
		
	}
	
	public void setHelmet(ItemStack helmet) {
		this.helmet = helmet;
	}
	
	public ItemStack getHelmet() {
		return helmet;
	}
	
	public float getHelmetDropChance() {
		return helmetDropChance;
	}
	
	public void setChestplate(ItemStack chestplate) {
		this.chestplate = chestplate;
	}
	
	public ItemStack getChestplate() {
		return chestplate;
	}
	
	public float getChestplateDropChance() {
		return chestplateDropChance;
	}
	
	public void setLeggings(ItemStack leggings) {
		this.leggings = leggings;
	}
	
	public ItemStack getLeggings() {
		return leggings;
	}
	
	public float getLeggingsDropChance() {
		return leggingsDropChance;
	}
	
	public void setBoots(ItemStack boots) {
		this.boots = boots;
	}
	
	public ItemStack getBoots() {
		return boots;
	}
	
	public float getBootsDropChance() {
		return bootsDropChance;
	}
	
	public void setMainHand(ItemStack mainhand) {
		this.mainhand = mainhand;
	}
	
	public ItemStack getMainHand() {
		return mainhand;
	}
	
	public float getMainHandDropChance() {
		return mainhandDropChance;
	}
	
	public void setOffHand(ItemStack offhand) {
		this.offhand = offhand;
	}
	
	public ItemStack getOffHand() {
		return offhand;
	}
	
	public float getOffHandDropChance() {
		return offhandDropChance;
	}
	
	public void setHelmetDropChance(float chance) {
		helmetDropChance = chance;
	}
	
	public void setChestplateDropChance(float chance) {
		chestplateDropChance = chance;
	}
	
	public void setLeggingsDropChance(float chance) {
		leggingsDropChance = chance;
	}
	
	public void setBootsDropChance(float chance) {
		bootsDropChance = chance;
	}
	
	public void setMainHandDropChance(float chance) {
		mainhandDropChance = chance;
	}
	
	public void setOffHandDropChance(float chance) {
		offhandDropChance = chance;
	}
}
