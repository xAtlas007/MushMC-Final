package br.com.mushmc.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import br.com.mushmc.apis.ItemBuilder;
import br.com.mushmc.apisdoedu.BukkitBungeeAPI;
import br.com.mushmc.apisdoedu.Mine;

public class GamesMenu implements Listener{

	private static GamesMenu instance;
	public static GamesMenu getInstance() {
		
		return instance;
		
	}
	
	public static void abrirMenu(Player p) {
		
		Inventory menu = Bukkit.createInventory(null, 4 * 9, "Selecionar jogo");
		
		ItemStack hg = new ItemBuilder(Material.MUSHROOM_SOUP)
				.setName("§aHG")
				.setLore("§7" + BukkitBungeeAPI.getPlayerCount("hg") + " §7Jogando agora").toItemStack();
		
		ItemStack duels = new ItemBuilder(Material.DIAMOND_SWORD)
				.setName("§aDuels")
				.setLore("§7" + BukkitBungeeAPI.getPlayerCount("duels") + " §7Jogando agora").toItemStack();
		
		ItemStack pvp = new ItemBuilder(Material.IRON_CHESTPLATE)
				.setName("§aPvP")
				.setLore("§7" + BukkitBungeeAPI.getPlayerCount("pvp") + " §7Jogando agora").toItemStack();
		
		ItemStack party = new ItemBuilder(Material.CAKE)
				.setName("§aParty")
				.setLore("§7" + BukkitBungeeAPI.getPlayerCount("party") + " §7Jogando agora").toItemStack();
		
		ItemStack gladiator = new ItemBuilder(Material.IRON_FENCE)
				.setName("§aGladiator (Agora no Duels)")
				.setLore("§7" + BukkitBungeeAPI.getPlayerCount("gladiator") + " §7Jogando agora").toItemStack();
		
		ItemStack x1 = new ItemBuilder(Material.BLAZE_ROD)
				.setName("§a1v1 (Agora no Duels)")
				.setLore("§7" + BukkitBungeeAPI.getPlayerCount("1v1") + " §7Jogando agora").toItemStack();
		
		ItemStack skywars = new ItemBuilder(Material.EYE_OF_ENDER)
				.setName("§aSkywars")
				.setLore("§7" + BukkitBungeeAPI.getPlayerCount("skywars") + " §7Jogando agora").toItemStack();
		
		ItemStack ctf = new ItemBuilder(Material.WOOL)
				.setName("§aCTF")
				.setLore("§7" + BukkitBungeeAPI.getPlayerCount("ctf") + " §7Jogando agora").toItemStack();
		
		ItemStack thebridge = new ItemBuilder(Material.STAINED_CLAY)
				.setName("§aThe Bridge")
				.setLore("§7" + BukkitBungeeAPI.getPlayerCount("thebridge") + " §7Jogando agora").toItemStack();
		
		menu.setItem(Mine.getPosition(2, 2), hg);
		menu.setItem(Mine.getPosition(2, 3), duels);
		menu.setItem(Mine.getPosition(2, 4), pvp);
		menu.setItem(Mine.getPosition(2, 5), party);
		menu.setItem(Mine.getPosition(2, 6), gladiator);
		menu.setItem(Mine.getPosition(2, 7), x1);
		menu.setItem(Mine.getPosition(2, 8), skywars);
		menu.setItem(Mine.getPosition(3, 2), ctf);
		menu.setItem(Mine.getPosition(3, 3), thebridge);
		p.openInventory(menu);
		
	}
	
	@EventHandler
	
	public void abrirMenuAoClicar(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		
		if (p.getItemInHand().getType() == Material.COMPASS) {
			
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR);
			GamesMenu.abrirMenu(p);
			
		}

		if (p.getItemInHand().getType() == Material.NETHER_STAR) {
			
			
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR);
			LobbyMenu.createInventory(p);
			
		}
		
	}
	
}
