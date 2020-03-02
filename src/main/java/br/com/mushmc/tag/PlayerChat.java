package br.com.mushmc.tag;

import org.apache.logging.log4j.core.appender.AsyncAppender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import br.com.mushmc.apisdoedu.MineReflect;
import br.com.mushmc.apisdoedu.VaultAPI;

public class PlayerChat implements Listener {

	@EventHandler
	
	public void chatTag(AsyncPlayerChatEvent e) {
		
		Player p = e.getPlayer();
		
// Cargo.getPlayerCargo(p).getTag()
		
		// dinheiro 
		 double dinheiro = VaultAPI.getEconomy().getBalance(p);
		 
		e.setFormat("" + VaultAPI.getPlayerGroupPrefix(p.getName()) +" "+ p.getDisplayName() + " §7(§f§7) §f" + e.getMessage());
	}
	
}
