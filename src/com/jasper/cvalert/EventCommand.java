package com.jasper.cvalert;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EventCommand implements CommandExecutor {

	private Main main;
	
	public EventCommand(Main main) {
		this.main = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		 
		if (player.hasPermission("cvalert.event")) {
			if (args.length > 0) {
		String event = main.getConfig().getString("Event");
		 String color = main.getConfig().getString("tekstkleur");
		
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]);
            sb.append(" ");
        }

        String combinedArgs = sb.toString();
        
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', event) + ChatColor.translateAlternateColorCodes('&', color)+ " " + combinedArgs); 
			} else {
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f[&9&lCV&f] &cJe hebt geen argumenten gegeven."));
			}
		} else {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f[&9&lCV&f] &cJij hebt geen permissions om dit commando uit te voeren."));
		}
		return false;
	}

}

