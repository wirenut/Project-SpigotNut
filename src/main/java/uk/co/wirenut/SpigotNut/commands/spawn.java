package uk.co.wirenut.SpigotNut.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class spawn implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	
    	if(sender instanceof Player) {
    		
    		Player player = (Player) sender;

    		if(!player.hasPermission("wirenut.spawn.other") && args.length == 1){
				Bukkit.getLogger().info(player.getName() + " tried to use /spawn and does not have permission!");
				player.sendMessage("You do not have permission!");
				return true;
			}
    		
    		if(!player.hasPermission("wirenut.spawn") && args.length == 0) {
    			Bukkit.getLogger().info(player.getName() + " tried to use /spawn and does not have permission!");
    			player.sendMessage("You do not have permission!");
    			return true;
    		}
    		
    		Location spawnLocation = player.getWorld().getSpawnLocation();
    		
    		player.teleport(spawnLocation);
    		
    		
    		
    		Bukkit.getLogger().info(player.getName() + " teleported to spawn!");
    		player.sendMessage("Teleporting to spawn!");
    		
    		return true;
    		
    	}
    	
    	
        return false;
    }
}
