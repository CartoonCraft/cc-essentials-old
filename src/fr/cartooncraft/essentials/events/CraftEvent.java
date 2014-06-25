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
		Material juicer = Material.getMaterial(3911);
		Material craftedType = e.getInventory().getResult().getType();
		if(craftedType == Material.getMaterial(3900) || craftedType == Material.getMaterial(3901) || craftedType == Material.getMaterial(3902) || craftedType == Material.getMaterial(3903) || craftedType == Material.getMaterial(3904) || craftedType == Material.getMaterial(3905) || craftedType == Material.getMaterial(3906) || craftedType == Material.getMaterial(3907) || craftedType == Material.getMaterial(3908) || craftedType == Material.getMaterial(3909)) {
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
