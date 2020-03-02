package br.com.mushmc.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class AtlasEvent implements Listener {

	@EventHandler
	
	public void PlayerLeaveListener(PlayerKickEvent e) {
		
		e.setLeaveMessage(null);
		
	}
	
	@EventHandler
	public final void onBlockPlaceEvent(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public final void onBlockBreakEvent(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public final void onDamageEntity(final EntityDamageEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public final void onWeatherChangeEvent(final WeatherChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public final void onFoodLevelChangeEvent(final FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public final void onPlayerAchievementAwardedEvent(final PlayerAchievementAwardedEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public final void onCreatureSpawnEvent(final CreatureSpawnEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public final void onPlayerDropItemEvent(final PlayerDropItemEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public final void onPlayerPickupItemEvent(final PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (player.getLocation().getY() < 5) {
			player.teleport(player.getWorld().getSpawnLocation());
		}
	}
}
	
	