package fr.cartooncraft.essentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.cartooncraft.essentials.commands.ListCommand;
import fr.cartooncraft.essentials.commands.SpawnCommand;

public class Main extends JavaPlugin {

	public void onEnable() {
		getLogger().info("CC-Essentials is loaded.");
	}
	
	public void onDisable() {
		getLogger().info("CC-Essentials is unloaded.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		// Commands
		
		if(cmd.getName().equalsIgnoreCase("spawn"))
			new SpawnCommand(sender);
		if(cmd.getName().equalsIgnoreCase("list"))
			new ListCommand(sender);
		return false;
	}
}