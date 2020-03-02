package br.com.mushmc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import br.com.mushmc.BukkitMain;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;

public class NpcCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		
		if(!(sender instanceof Player)) {
			
			Bukkit.getConsoleSender().sendMessage("§b§lCOMMONS §fApenas jogadores podem fazer isso!");
			
			return false;
			
		}
		Player p = (Player)sender;
		NPCRegistry npcRegistrador = CitizensAPI.getNPCRegistry();
		NPC npc = npcRegistrador.createNPC(EntityType.PLAYER,BukkitMain.getInstance().getNpcServidores() );
		npc.spawn(p.getLocation());
		npc.data().set(NPC.PLAYER_SKIN_UUID_METADATA,"92272ead-fd3c-425a-8098-1034a8d4a31f");
		
		return false;
	}

}
