package fr.cartooncraft.essentials.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class CraftEvent implements Listener {
	
	Plugin p = null;
	
	public CraftEvent(Plugin a) {
		this.p = a;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onCraft(CraftItemEvent e) {
		Material juicer = Material.getMaterial(4167);
		Material craftedType = e.getInventory().getResult().getType();
		if(craftedType == Material.getMaterial(4156) || craftedType == Material.getMaterial(4157) || craftedType == Material.getMaterial(4158) || craftedType == Material.getMaterial(4159) || craftedType == Material.getMaterial(4160) || craftedType == Material.getMaterial(4161) || craftedType == Material.getMaterial(4162) || craftedType == Material.getMaterial(4163) || craftedType == Material.getMaterial(4164) || craftedType == Material.getMaterial(4165)) {
			HumanEntity guyWhoClicked = e.getWhoClicked();
			ItemStack juicerIS = new ItemStack(juicer, 1);
			if(guyWhoClicked.getInventory().firstEmpty() == -1) {
				e.setCancelled(true);
				Bukkit.getPlayerExact(e.getWhoClicked().getName()).sendMessage(ChatColor.RED+"You need to have space in your inventory to craft this!");
			}
			else {
				guyWhoClicked.getInventory().addItem(juicerIS);
			}
		}
	}

}
