package fr.cartooncraft.essentials.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class ChatEvent implements Listener {

	Plugin p = null;
	
	public ChatEvent(Plugin a) {
		this.p = a;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent ev) {
		ev.setCancelled(true);
		Player p = ev.getPlayer();
		if(p.isOp()) {
			Bukkit.broadcastMessage(ChatColor.RESET+"<"+ChatColor.RED+p.getCustomName()+ChatColor.RESET+"> "+ev.getMessage());
		}
		else {
			Bukkit.broadcastMessage(ChatColor.RESET+"<"+p.getCustomName()+"> "+ev.getMessage());
		}
	}
	

}
