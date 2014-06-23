package fr.cartooncraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cartooncraft.essentials.CCCommand;

public class TPCommand extends CCCommand {

	public TPCommand(CommandSender sender, String[] args) {
		if(args.length != 1) {
			sender.sendMessage(ChatColor.RED+"Nope! Usage: /tp <player>");
		}
		else {
			if(isPlayer(sender)) {
				Player p = getPlayer(sender);
				if(p.isOp()) {
					if(Bukkit.getPlayer(args[0]) == null) {
						sender.sendMessage(getPlayerNotFoundSentence(args[0]));
					}
					else {
						Player p2 = Bukkit.getPlayer(args[0]);
						p.teleport(p2.getLocation());
						sender.sendMessage(ChatColor.RED+"You have been teleported to "+p2.getName()+".");
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
	}

}
