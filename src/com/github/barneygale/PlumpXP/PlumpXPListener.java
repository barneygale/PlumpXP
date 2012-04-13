package com.github.barneygale.PlumpXP;

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
		EntityType etype = event.getEntityType();
		if(etype != EntityType.PLAYER) {
			double xp = (double)event.getDroppedExp();
			if(etype == EntityType.BLAZE) {
				xp*=plugin.config.BLAZE_MULTIPLIER;
			}
			xp*=plugin.config.PLUMP_MULTIPLIER;
			event.setDroppedExp((int)xp);
		}
	}
}
