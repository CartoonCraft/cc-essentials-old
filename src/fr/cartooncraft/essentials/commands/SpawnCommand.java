package fr.cartooncraft.essentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cartooncraft.essentials.CCCommand;

public class SpawnCommand extends CCCommand {
	
	public SpawnCommand(CommandSender sender) {
		if(isPlayer(sender)) {
			Player p = getPlayer(sender);
			if(p.isOp())
				p.teleport(new Location(Bukkit.getWorld("world"), -685.5, 64, 327.5, 90, 0));
			else
				p.sendMessage(noPermission);
		}
		else {
			sender.sendMessage(senderConsole);
		}
	}
	
}
