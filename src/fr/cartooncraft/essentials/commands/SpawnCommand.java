package fr.cartooncraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cartooncraft.essentials.CCCommand;

public class SpawnCommand extends CCCommand {
	
	public SpawnCommand(CommandSender sender) {
		if(isPlayer(sender)) {
			Player p = getPlayer(sender);
			if(p.isOp())
				p.teleport(Bukkit.getWorld("world").getSpawnLocation());
			else
				p.sendMessage(noPermission);
		}
		else {
			sender.sendMessage(senderConsole);
		}
	}
	
}
