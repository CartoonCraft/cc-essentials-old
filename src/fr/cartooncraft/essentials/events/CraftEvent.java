package fr.cartooncraft.essentials.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import fr.cartooncraft.essentials.CCCommand;

public class CraftEvent extends CCCommand implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onCraft(CraftItemEvent e) {
		System.out.println("lel event");
		Material juicer = Material.getMaterial(4167);
		Material craftedType = e.getInventory().getResult().getType();
		System.out.println("craftedtype: "+craftedType.getId());
		if(craftedType == Material.getMaterial(4156) || craftedType == Material.getMaterial(4157) || craftedType == Material.getMaterial(4158) || craftedType == Material.getMaterial(4159) || craftedType == Material.getMaterial(4160) || craftedType == Material.getMaterial(4161) || craftedType == Material.getMaterial(4162) || craftedType == Material.getMaterial(4163) || craftedType == Material.getMaterial(4164) || craftedType == Material.getMaterial(4165)) {
			Bukkit.getLogger().info("condition OK");
			HumanEntity guyWhoClicked = e.getWhoClicked();
			Bukkit.getLogger().info("getWhoClicked name: "+guyWhoClicked.getName()+guyWhoClicked.getInventory().firstEmpty());
			ItemStack juicerIS = new ItemStack(juicer, 1);
			if(guyWhoClicked.getInventory().firstEmpty() == -1) {
				e.setCancelled(true);
				Bukkit.getPlayerExact(e.getWhoClicked().getName()).sendMessage(ChatColor.RED+"You need to have space in your inventory to craft this!");
				Bukkit.getLogger().info("need space");
			}
			else {
				guyWhoClicked.getInventory().addItem(juicerIS);
				Bukkit.getLogger().info("gived");
			}
		}
	}

}
