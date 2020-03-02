package br.com.mushmc.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import br.com.mushmc.apisdoedu.MineReflect;
import br.com.mushmc.tag.CashAPI;
import br.com.mushmc.tag.PlayerTag;

public class PlayerListener implements Listener{
	
	@EventHandler
	
	public void oojio(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		p.setAllowFlight(false);
		p.setGameMode(GameMode.ADVENTURE);
		
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		p.sendMessage("");
		
		PlayerTag.getPlayerGroup(p);
		MineReflect.sendTitle(p, "§b§lMUSH", "§eSeja bem vindo!", 20, 20, 20);
		CashAPI.criarContaNoMySQL(p);
		
	}

}
