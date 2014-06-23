package fr.cartooncraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cartooncraft.essentials.CCCommand;

public class TPCommand extends CCCommand {

	public TPCommand(CommandSender sender, String[] args) {
		if(args.length == 1) {
			if(isPlayer(sender)) {
				Player p = getPlayer(sender);
				if(p.isOp()) {
					if(Bukkit.getPlayer(args[0]) == null) {
						sender.sendMessage(getPlayerNotFoundSentence(args[0]));
					}
					else {
						Player p2 = Bukkit.getPlayer(args[0]);
						p.teleport(p2.getLocation());
						sender.sendMessage(ChatColor.RED+"You have been teleported to "+getPlayerName(p2)+".");
					}
				}
				else {
					sender.sendMessage(noPermission);
				}
			}
			else {
				sender.sendMessage(senderConsole);
			}
		}
		if(args.length == 2) {
			if(sender.isOp()) {
				Player p1 = null;
				Player p2 = null;
				if(Bukkit.getPlayer(args[0]) == null) {
					sender.sendMessage(getPlayerNotFoundSentence(args[0]));
				}
				else if(Bukkit.getPlayer(args[1]) == null) {
					sender.sendMessage(getPlayerNotFoundSentence(args[1]));
				}
				else {
					p1 = Bukkit.getPlayer(args[0]);
					p2 = Bukkit.getPlayer(args[0]);
					p1.teleport(p2);
					sender.sendMessage(getPlayerName(p1)+ChatColor.RESET+" has been teleported to "+getPlayerName(p2));
				}
			}
			else {
				sender.sendMessage(noPermission);
			}
		}
		else {
			sender.sendMessage(ChatColor.RED+"Nope! Usage: /tp <player>");
		}
	}

}
