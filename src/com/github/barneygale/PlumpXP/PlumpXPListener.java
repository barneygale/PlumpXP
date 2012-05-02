package com.github.barneygale.PlumpXP;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlumpXPListener implements Listener {
    public final PlumpXP plugin;
    public PlumpXPListener(PlumpXP instance) {
        plugin = instance;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
         Entity target = event.getEntity();
         Player attacker = getAttacker(target.getLastDamageCause());
         int xp = event.getDroppedExp();
         
         if(event instanceof PlayerDeathEvent) {
                handlePlayerDeath((PlayerDeathEvent) event,attacker, xp);
                return;
         }

         //not killed by player
         if(attacker == null) {
                return;
            }
         handleMonsterDeath(event, xp);
        }

    private void handleMonsterDeath(EntityDeathEvent event, int exp) {
        EntityType target = event.getEntityType();

        if (target == EntityType.BLAZE) {
            exp *= plugin.config.BLAZE_MULTIPLIER;
        }
        else {
            exp *= plugin.config.PLUMP_MULTIPLIER;
        }
        event.setDroppedExp(exp);
    }

    private void handlePlayerDeath(PlayerDeathEvent event,Player attacker, int exp) {
        //killed by another player
        if ((attacker != null) && (plugin.config.PLAYER_OVERRIDE)) {
            exp *= plugin.config.PLAYER_MULTIPLIER;
        }
        event.setDroppedExp(exp);
    }

    private Player getAttacker(EntityDamageEvent attacker) {
        if((attacker == null) || (!(attacker instanceof EntityDamageByEntityEvent))){
            return null;
        }

        Player p = null;
        Entity damager = ((EntityDamageByEntityEvent) attacker).getDamager();

        if(damager instanceof Projectile) {
            Projectile projectile = (Projectile) damager;
            if(projectile.getShooter() instanceof Player) {
                p = (Player) projectile.getShooter();
            }
        } 
        else if(damager instanceof Player) {
            p = (Player)damager;
        }
        return p;
    }
}
