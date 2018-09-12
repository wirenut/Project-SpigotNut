package uk.co.wirenut.plugin.commands.home;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandHome implements CommandExecutor {


	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	
    	if(sender instanceof Player) {
    		
    		Player player = (Player) sender;
    		
    		if(!player.hasPermission("wirenut.home")) {
    			Bukkit.getLogger().info(player.getName() + " tried to use /home and does not have permission!");
    			player.sendMessage("You do not have permission!");
    			return true;
    		}
    		
    		
    		Location homeLocation = new Location(null, 0, 0, 0);
    		
    		homeLocation.setWorld(Bukkit.getWorld(player.getMetadata("wirenut.home.world").get(0).asString()));
    		homeLocation.setX(player.getMetadata("wirenut.home.x").get(0).asInt());
    		homeLocation.setY(player.getMetadata("wirenut.home.y").get(0).asInt());
    		homeLocation.setZ(player.getMetadata("wirenut.home.z").get(0).asInt());
    		homeLocation.setPitch(player.getMetadata("wirenut.home.pitch").get(0).asInt());
    		homeLocation.setYaw(player.getMetadata("wirenut.home.yaw").get(0).asInt());
    		
    		Bukkit.getLogger().info(homeLocation.toString());
    		
    		player.teleport(homeLocation);
    		
    		
    		
    		Bukkit.getLogger().info(player.getName() + " teleported to home!");
    		player.sendMessage("Teleporting to home!");
    		
    		return true;
    		
    	}
    	
    	
        return false;
    }
}
