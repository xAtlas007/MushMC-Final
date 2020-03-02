package br.com.mushmc.menu;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.mushmc.apis.ItemBuilder;
import br.com.mushmc.apisdoedu.Mine;

public class LobbyMenu implements Listener {

	private static LobbyMenu instance;
	public static LobbyMenu getInstance() {
		
		return instance;
		
	}
	
	public static void createInventory(Player p) {
		
		List<String> lore;
		
		Inventory lobby = Bukkit.createInventory(null, 9 * 3, "§7Selecionar lobby");
		
//		ItemStack vidro1 = new ItemBuilder(Material.STAINED_GLASS_PANE)
//				.setName("§aLobby: §b#1")
//				.setLore("§fJogadores: " + Bukkit.getOnlinePlayers().size()).toItemStack();

		ItemStack vidro1 = new ItemStack(160, 1, (byte)5);
		ItemMeta ativadom = vidro1.getItemMeta();
		ativadom.setDisplayName("§fLobby §a#1");
		vidro1.setItemMeta(ativadom);
		lobby.setItem(Mine.getPosition(2, 3), vidro1);
		
		ItemStack vidro2 = new ItemStack(160, 1, (byte)14);
		ItemMeta desativadom = vidro2.getItemMeta();
		desativadom.setDisplayName("§cDesativado");
		lobby.setItem(Mine.getPosition(2, 4), vidro2);
		
		p.openInventory(lobby);
		
	}
	
}
