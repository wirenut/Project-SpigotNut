package uk.co.wirenut.SpigotNut.commands.home;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import uk.co.wirenut.SpigotNut.SpigotNut;


public class sethome implements CommandExecutor {

	private SpigotNut plugin = SpigotNut.getInstance();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	
    	if(sender instanceof Player) {
    		
    		Player player = (Player) sender;
    		
    		if(!player.hasPermission("wirenut.sethome")) {
    			Bukkit.getLogger().info(player.getName() + " tried to use /sethome and does not have permission!");
    			player.sendMessage("You do not have permission!");
    			return true;
    		}
    		
    		Location homeLocation = player.getLocation();   				
    		
    		//player.teleport(homeLocation);
    		
    		Bukkit.getLogger().info(homeLocation.toString());
    		
    		player.setMetadata("wirenut.home.x", new FixedMetadataValue(plugin, homeLocation.getX()));
    		player.setMetadata("wirenut.home.y", new FixedMetadataValue(plugin, homeLocation.getY()));
    		player.setMetadata("wirenut.home.z", new FixedMetadataValue(plugin, homeLocation.getZ()));
    		player.setMetadata("wirenut.home.world", new FixedMetadataValue(plugin, player.getWorld().getName()));
    		player.setMetadata("wirenut.home.pitch", new FixedMetadataValue(plugin, homeLocation.getPitch()));
    		player.setMetadata("wirenut.home.yaw", new FixedMetadataValue(plugin, homeLocation.getYaw()));
    		
    		Bukkit.getLogger().info(player.getName() + " home set!");
    		player.sendMessage("Home Set!");
    		
    		return true;
    		
    	}
    	
    	
        return false;
    }
}
