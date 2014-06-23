package fr.cartooncraft.essentials;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import fr.cartooncraft.essentials.commands.KillCommand;
import fr.cartooncraft.essentials.commands.ListCommand;
import fr.cartooncraft.essentials.commands.SpawnCommand;
import fr.cartooncraft.essentials.commands.TPCommand;
import fr.cartooncraft.essentials.events.ChatEvent;

public class Main extends JavaPlugin {

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new ChatEvent(this), this);
		getLogger().info("CC-Essentials is loaded.");
	}
	
	public void onDisable() {
		getLogger().info("CC-Essentials is unloaded.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		// Commands
		if(cmd.getName().equalsIgnoreCase("spawn"))
			new SpawnCommand(sender);
		else if(cmd.getName().equalsIgnoreCase("list"))
			new ListCommand(sender);
		else if(cmd.getName().equalsIgnoreCase("tp"))
			new TPCommand(sender, args);
		else if(cmd.getName().equalsIgnoreCase("kill"))
			new KillCommand(sender, args);
		else {
			return false;
		}
		return true;
	}
	
}