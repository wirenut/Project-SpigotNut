package uk.co.wirenut.plugin;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.wirenut.plugin.commands.CommandSpawn;
import uk.co.wirenut.plugin.commands.home.CommandHome;
import uk.co.wirenut.plugin.commands.home.CommandSetHome;

public class SpigotNut extends JavaPlugin {
	
	
	private static SpigotNut instance;
	
	public static SpigotNut getInstance() {
		return instance;
	}
	
	
    
	@Override
	public void onEnable() {
		
		instance = this;
		
		
		this.getCommand("spawn").setExecutor(new CommandSpawn());
		
		
		this.getCommand("sethome").setExecutor(new CommandSetHome());
		this.getCommand("home").setExecutor(new CommandHome());
	}
	
	@Override
	public void onDisable() {
		
	}

}
