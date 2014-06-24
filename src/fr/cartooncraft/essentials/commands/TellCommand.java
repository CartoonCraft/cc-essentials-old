package fr.cartooncraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cartooncraft.essentials.CCCommand;

public class TellCommand extends CCCommand {
	
	public TellCommand(CommandSender sender, String[] args) {
		/*if(sender.isOp()) {
			String message = ""+ChatColor.RED+ChatColor.BOLD;
			for(String arg : args) {
				message += arg+" ";
			}
			
			// Remove last space - copy-paste from Stackoverflow :D
			
			if (message.length() > 0 && message.charAt(message.length()-1)==' ') {
				message = message.substring(0, message.length()-1);
			}
			
			Bukkit.broadcastMessage(message); 
		}*/
		
		String message = "";
		String playerName = "";
		boolean firstArg = true;
		for(String arg : args) {
			if(firstArg) {
				playerName = arg;
			}
			else {
				message += arg+" ";
			}
			firstArg = false;
		}
		
		// Remove last space - copy-paste from Stackoverflow :D
		if (message.length() > 0 && message.charAt(message.length()-1)==' ') {
			message = message.substring(0, message.length()-1);
		}
		
		Player p2 = Bukkit.getPlayer(playerName);
		if(p2 == null) {
			sender.sendMessage(getPlayerNotFoundSentence(playerName));
			return;
		}
		String m;
		if(sender instanceof Player) {
			Player p1 = (Player)sender;
			m = ChatColor.GOLD+"["+ChatColor.GRAY+getPlayerName(p1)+ChatColor.GOLD+"->"+ChatColor.GRAY+getPlayerName(p2)+ChatColor.GOLD+"] "+ChatColor.RESET+message;
		}
		else {
			m = ChatColor.GOLD+"["+ChatColor.RED+"CONSOLE"+ChatColor.GOLD+"->"+ChatColor.GRAY+getPlayerName(p2)+ChatColor.GOLD+"] "+ChatColor.RESET+message;
		}
		sender.sendMessage(m);
		p2.sendMessage(m);
	}

}