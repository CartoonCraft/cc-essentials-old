package fr.cartooncraft.essentials;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CCCommand {

	public String noPermission = ""+ChatColor.RESET+ChatColor.RED+"Sorry, you're not authorized to do this.";
	public String senderConsole = ""+ChatColor.RESET+ChatColor.RED+"Sorry, you're a console, you can't do this!";
	
	public boolean isPlayer(CommandSender sender) {
		return(sender instanceof Player);
	}
	
	public Player getPlayer(CommandSender sender) {
		if(isPlayer(sender)) {
			return (Player)sender;
		}
		return null;
	}
	
	public String getPlayerNotFoundSentence(String name) {
		return ChatColor.RED+"Can't find "+name+". Is him offline?";
	}
	
	public String getPlayerName(Player p) {
		String name = "";
		if(p.isOp())
			name += ChatColor.RED;
		name += p.getName();
		return name;
	}
}
