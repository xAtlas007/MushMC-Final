package br.com.mushmc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import br.com.mushmc.BukkitMain;
import io.netty.channel.epoll.Epoll;
import net.citizensnpcs.api.event.NPCClickEvent;

public class CitizensEventos implements Listener{

	
	@EventHandler
	public void event(NPCClickEvent e) {
		if (e.getNPC().getName().equals(BukkitMain.getInstance().getNpcServidores())) {
			 Player p = e.getClicker();
			p.chat("/servidores");
			
		}
	}
	
}
