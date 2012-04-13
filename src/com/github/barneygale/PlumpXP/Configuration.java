package com.github.barneygale.PlumpXP;

public class Configuration {
	private final PlumpXP plugin;
	public double PLUMP_MULTIPLIER;
	public double BLAZE_MULTIPLIER;
	
	public Configuration(PlumpXP instance) {
		plugin = instance;
	}
	public void save() {
		plugin.saveConfig();
	}
	public void load() {
		plugin.reloadConfig();
		PLUMP_MULTIPLIER = plugin.getConfig().getDouble("plump-multiplier");
		BLAZE_MULTIPLIER = plugin.getConfig().getDouble("blaze-multiplier");
	}

}
