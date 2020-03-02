package br.com.mushmc.menu;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import br.com.mushmc.apis.ItemBuilder;
import br.com.mushmc.apis.MakeItem;
import br.com.mushmc.apis.MakeItemHead;
import br.com.mushmc.apis.Skull;
import br.com.mushmc.apisdoedu.Mine;

@SuppressWarnings("unused")
public class PlayerSetItem implements Listener {
	
	
	
	// ATIVAR JOGADORES

	public static final ArrayList<Player> toHide = new ArrayList<>(); @SuppressWarnings("deprecation")
	
	public static final void updateP(Player p) {
		
		Bukkit.getOnlinePlayers().forEach(players -> {
			
			if(toHide.contains(p)) {
				
				p.hidePlayer(players);
				
			} else {
				
				p.showPlayer(players);
				
			}
			
		});
		
	}
	
	   public static void pHideShowMethod(Player p) {
		     for (int i = 1; i < 6; i++) {
		       updateP(p);
		     }
		  }
	
	@EventHandler
	
	public void gerarItens(PlayerJoinEvent e) {
		
		
		Player player = e.getPlayer();
	
		ItemStack bussola = new ItemBuilder(Material.COMPASS)
		.setName("§aSelecionar jogo").toItemStack();

        ItemStack bau = new ItemBuilder(Material.CHEST)
		.setName("§aColetáveis").toItemStack();
        
        
        ItemStack perfil = Mine.newHead("§aMeu Perfil", player.getName(), "");
        
       //ItemStack perfil = new MakeItem(player.getName()).setName("§aMeu Perfil").build();
        
        ItemStack lobby = new ItemBuilder(Material.NETHER_STAR)
		.setName("§aSelecionar Lobby").toItemStack();
		
       // ATIVAR  / DESATIVAR PLAYERS
        
        ItemStack ativado = new ItemStack(351, 1, (byte)10);
        ItemMeta ativadom = ativado.getItemMeta();
        ativadom.setDisplayName("§fJogadores: §aON");
        
		player.getInventory().setItem(0, bussola);
		player.getInventory().setItem(1, perfil);
		player.getInventory().setItem(4, bau);
		player.getInventory().setItem(7, ativado);
		player.getInventory().setItem(8, lobby);
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	
	public void advancedEvent(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		ItemStack ativado = new ItemStack(351, 1, (byte)10);
		ItemMeta ativadom = ativado.getItemMeta();
		ativadom.setDisplayName("§fJogadores: §aON");
		ativado.setItemMeta(ativadom);
		
		ItemStack desativado = new ItemStack(351, 1, (byte)8);
		ItemMeta desativadom = ativado.getItemMeta();
		desativadom.setDisplayName("§fJogadores: §cOFF");
		desativado.setItemMeta(desativadom);
		
		
	     if (p.getItemInHand().getType() == Material.getMaterial(351)) {
  	       if (toHide.contains(p)) {
			         e.setCancelled(true);
			         toHide.remove(p);
			         pHideShowMethod(p);
			         p.setItemInHand(ativado);
			         p.sendMessage("§b§lVISIBILIDADE §fVocê agora está vendo os jogadores.");
			         p.updateInventory();
			       } else {
			         e.setCancelled(true);
			         toHide.add(p);
			         pHideShowMethod(p);
			         p.setItemInHand(desativado);
			         p.sendMessage("§b§lVISIBILIDADE §fVocê agora não está mais vendo os jogadores.");
			 } 
		}
	}
}
