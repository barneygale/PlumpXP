package com.github.barneygale.PlumpXP;

import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;



public class PlumpXPListener implements Listener {
	public final PlumpXP plugin;
	public PlumpXPListener(PlumpXP instance) {
		plugin = instance;
	}
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		double xp = event.getDroppedExp();
		EntityType etype = event.getEntityType();
		
		if(etype == EntityType.PLAYER) {
			if(plugin.config.PLAYER_OVERRIDE) {
				xp = ((CraftPlayer)event.getEntity()).getTotalExperience();
				xp*= plugin.config.PLAYER_MULTIPLIER;
			}
		
		} else {
			if(etype == EntityType.BLAZE) {
				xp*=plugin.config.BLAZE_MULTIPLIER;
			}
			xp*=plugin.config.PLUMP_MULTIPLIER;
		}
		event.setDroppedExp((int)xp);
	}
	
}
