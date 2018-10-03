package uk.co.wirenut.SpigotNut.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class onBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        e.setCancelled(true);
    }
}
