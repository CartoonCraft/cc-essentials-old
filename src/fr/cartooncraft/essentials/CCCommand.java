package fr.cartooncraft.essentials;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CCCommand {

	public String noPermission = ChatColor.RED+"Sorry, you're not authorized to do this.";
	
	public boolean isPlayer(CommandSender sender) {
		if(sender instanceof Player)
			return true;
		else
			return false;
	}
	
	public Player getPlayer(CommandSender sender) {
		if(isPlayer(sender)) {
			return (Player)sender;
		}
		return null;
	}
}
