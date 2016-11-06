package me.ryantbhh;

import org.bukkit.plugin.java.JavaPlugin;

import me.ryantbhh.commands.InfoMe;

public class Main extends JavaPlugin {

	public void onEnable(){
		registerCommands();
		System.out.println("InfoMe by ryantbhh working!");
	}
	
	public void onDisable(){ }	
	
	public void registerCommands(){
		getCommand("infome").setExecutor(new InfoMe());
	}
}
