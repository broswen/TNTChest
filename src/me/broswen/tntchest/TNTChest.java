package me.broswen.tntchest;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTChest extends JavaPlugin implements Listener{
	public static TNTChest plugin;
	
	public void onEnable(){
		this.plugin = this;
		
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender sender, String label, String args[]){
		return true;
	}
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event){
		if(event.getEntity().getType() == EntityType.PRIMED_TNT && event.blockList().size() > 0 || event.getEntity().getType() == EntityType.CREEPER && event.blockList().size() > 0){
			Iterator<Block> iter = event.blockList().iterator();
	          while (iter.hasNext()) {
	              Block b = iter.next();
	              if (b.getType() == Material.CHEST || b.getType() == Material.TRAPPED_CHEST) {
	                  iter.remove();
	              }
	          }
	    }
	}
}
