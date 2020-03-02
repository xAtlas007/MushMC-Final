package br.com.mushmc.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import br.com.mushmc.apisdoedu.BukkitBungeeAPI;
import br.com.mushmc.apisdoedu.Mine;
import br.com.mushmc.menu.GamesMenu;

public class InventoryEvent implements Listener {

	@EventHandler
	
	public void clickEvent(InventoryClickEvent e) {
		
			if (e.getWhoClicked() instanceof Player) {
				Player p = (Player) e.getWhoClicked();
				if (e.getInventory().getName().equals("Selecionar jogo")) {
						e.setCancelled(true);
						if (e.getCurrentItem() == null)return;
						if (e.getSlot() == Mine.getPosition(2, 2)) {
							BukkitBungeeAPI.connectToServer(p, "hg");
						}
						if (e.getSlot() == Mine.getPosition(2, 3)) {
							
							BukkitBungeeAPI.connectToServer(p, "duels");
						}
						if (e.getSlot() == Mine.getPosition(2, 4)) {
							BukkitBungeeAPI.connectToServer(p, "pvp");
						}
						if (e.getSlot() == Mine.getPosition(2, 5)) {
							BukkitBungeeAPI.connectToServer(p, "party");
						}
						if (e.getSlot() == Mine.getPosition(2, 6)) {
							BukkitBungeeAPI.connectToServer(p, "gladiator");
						}
						if (e.getSlot() == Mine.getPosition(2, 7)) {
							BukkitBungeeAPI.connectToServer(p, "1v1");
						}
						if (e.getSlot() == Mine.getPosition(2, 8)) {
							BukkitBungeeAPI.connectToServer(p, "skywars");
						}
						if (e.getSlot() == Mine.getPosition(3, 2)) {
							BukkitBungeeAPI.connectToServer(p, "ctf");
						}
						if (e.getSlot() == Mine.getPosition(3, 3)) {
							BukkitBungeeAPI.connectToServer(p, "thebridge");
				    }
				}
			}
		}
	
	@EventHandler
	
	public void clickLobby(InventoryClickEvent e) {
		
		if (e.getWhoClicked() instanceof Player) {
			Player p = (Player) e.getWhoClicked();
			if (e.getInventory().getName().equals("§7Selecionar lobby")) {
					e.setCancelled(true);
					if (e.getCurrentItem() == null)return;
					if (e.getSlot() == Mine.getPosition(2, 2)) {
					}
		
			}
		}
	}
}
	