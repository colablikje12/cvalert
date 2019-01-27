package com.jasper.cvalert;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		System.out.println("[CV] CVAlert is nu aangezet!");
		
		getCommand("info").setExecutor(new InfoCommand(this));
		getCommand("alert").setExecutor(new AlertCommand(this));
		getCommand("event").setExecutor(new EventCommand(this));
		getCommand("mededeling").setExecutor(new MededelingCommand(this));
		
		this.getConfig().options().copyDefaults();
		saveDefaultConfig();
	}
}
