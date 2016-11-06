package me.ryantbhh.commands;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;



public class InfoMe implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		
		Player player = (Player)sender;
	
		  String sURL = "http://ip-api.com/json"; 

		    
		    URL url = null;
			try {
				url = new URL(sURL);
			} catch (MalformedURLException e2){ 
			
				e2.printStackTrace();
			}
		    HttpURLConnection request = null;
			try {
				request = (HttpURLConnection) url.openConnection();
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}
		    try {
				request.connect();
			} catch (IOException e) {
			
				e.printStackTrace();
			}

		  
		    JsonParser jp = new JsonParser(); 
		    JsonElement root = null;
			try {
				root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
			} catch (JsonIOException | JsonSyntaxException | IOException e) {
			
				e.printStackTrace();
			} 
		    JsonObject rootobj = root.getAsJsonObject();  
		    
		    
		    String city = rootobj.get("city").getAsString(); 
		    String country = rootobj.get("country").getAsString(); 
		    String zip = rootobj.get("zip").getAsString(); 
		    String as = rootobj.get("as").getAsString();
		    String lat = rootobj.get("lat").getAsString();
		    String lon = rootobj.get("lon").getAsString();
		    String isp = rootobj.get("isp").getAsString();
		    String tz = rootobj.get("timezone").getAsString();
		    
		    player.sendMessage(ChatColor.GOLD + "Here's all the Info we could find:\n");
		    
		    player.sendMessage(ChatColor.DARK_AQUA + "Your City: "    +ChatColor.AQUA + city);
		    player.sendMessage(ChatColor.DARK_AQUA + "Your Country: " +ChatColor.AQUA + country);
		    player.sendMessage(ChatColor.DARK_AQUA + "Zip Code: "     +ChatColor.AQUA + zip);
		    player.sendMessage(ChatColor.DARK_AQUA + "Using: "	 	  +ChatColor.AQUA + as);
		    player.sendMessage(ChatColor.DARK_AQUA + "Latitude: " 	  +ChatColor.AQUA + lat);
		    player.sendMessage(ChatColor.DARK_AQUA + "Longitude: "    +ChatColor.AQUA + lon);
		    player.sendMessage(ChatColor.DARK_AQUA + "ISP: " 		  +ChatColor.AQUA + isp);
		    player.sendMessage(ChatColor.DARK_AQUA + "TimeZone: "	  +ChatColor.AQUA + tz);
		    
		    return false;
	}

}
