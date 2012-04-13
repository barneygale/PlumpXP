package com.github.barneygale.PlumpXP;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PlumpXP extends JavaPlugin {
		private final PlumpXPListener xplistener = new PlumpXPListener(this);
		Logger log = Logger.getLogger("Minecraft");
		public final Configuration config = new Configuration(this);
		public void onEnable(){
			log = this.getLogger();
			
			//Load config
			File config_file = new File(getDataFolder(), "config.yml");
			if(!config_file.exists()) {
				getConfig().options().copyDefaults(true);
				saveConfig();
			}
			config.load();
			
			//Register listener
			PluginManager pm = getServer().getPluginManager();
			pm.registerEvents(xplistener, this);
			
			log.info("PlumpXP has been enabled!");
		}
	 
		public void onDisable(){
			log.info("PlumpXP has been disabled.");
		}
}
