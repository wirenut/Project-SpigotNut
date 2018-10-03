package uk.co.wirenut.SpigotNut;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.wirenut.SpigotNut.commands.spawn;
import uk.co.wirenut.SpigotNut.commands.home.home;
import uk.co.wirenut.SpigotNut.commands.home.sethome;

public class SpigotNut extends JavaPlugin {
	
	
	private static SpigotNut instance;
	
	public static SpigotNut getInstance() {
		return instance;
	}
	
	
    
	@Override
	public void onEnable() {
		
		instance = this;
		
		
		this.getCommand("spawn").setExecutor(new spawn());
		
		this.getCommand("sethome").setExecutor(new sethome());
		this.getCommand("home").setExecutor(new home());

		this.getServer().getPluginManager().registerEvents(new portal(this), this);

	}
	
	@Override
	public void onDisable() {
		
	}

}
