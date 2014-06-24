package fr.cartooncraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cartooncraft.essentials.CCCommand;

public class KickCommand extends CCCommand {
	
	public KickCommand(CommandSender sender, String[] args) {
		if(args.length < 1) {
			sender.sendMessage(ChatColor.RED+"Nope! Usage: /kick <player> <reason>");
		}
		else {
			if(sender.isOp()) {
				Player p = Bukkit.getPlayer(args[0]);
				if(p == null) {
					sender.sendMessage(getPlayerNotFoundSentence(args[0]));
				}
				else {
					boolean firstArg = true;
					String message = "";
					for(String arg : args) {
						if(!firstArg)
							message += arg+" ";
						firstArg = false;
					}
					// Remove last space - copy-paste from Stackoverflow :D
					if (message.length() > 0 && message.charAt(message.length()-1)==' ') {
						message = message.substring(0, message.length()-1);
					}
					if(message.isEmpty())
						message = "Kicked by "+sender.getName();
					p.kickPlayer(message);
				}
			}
			else {
				sender.sendMessage(noPermission);
			}
		}
	}

}
