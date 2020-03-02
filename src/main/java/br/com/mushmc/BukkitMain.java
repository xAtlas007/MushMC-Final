package br.com.mushmc;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.mushmc.commands.NpcCommand;
import br.com.mushmc.events.AtlasEvent;
import br.com.mushmc.events.InventoryEvent;
import br.com.mushmc.listener.PlayerListener;
import br.com.mushmc.menu.GamesMenu;
import br.com.mushmc.menu.PlayerSetItem;
import br.com.mushmc.scoreboard.ScoreboardComDisplayboard;
import br.com.mushmc.tag.CashAPI;
import br.com.mushmc.tag.CashComando;
import br.com.mushmc.tag.PlayerChat;

public class BukkitMain extends JavaPlugin {

	// Esta fun��o � ultilizada para puxar m�todos fora da Classe BukkitMain (Use
	// BukkitMain.getInstance()."FUNCAO")
	private static BukkitMain instance;
	private static BukkitMain plugin;
	private String npcServidores = "§aServidores";

	public static BukkitMain getInstance() {
		return instance;
	}

	public static BukkitMain getPlugin() {
		return plugin;
	}

	@Override

	public void onEnable() {
		instance = this;
		plugin = this;
		Bukkit.getConsoleSender().sendMessage("§c§lCONSOLE §fPlugin iniciado com sucesso!");

		Bukkit.getConsoleSender().sendMessage("§b§lCOMMONS §fIniciado com sucesso!");
		
		BukkitConfig();
		getEvents();
		getCommands();
		ScoreboardComDisplayboard.ligar(this);
		
		CashAPI.getDB().openMySQLConnection();
		if (CashAPI.getDB().hasConnection()) {
			CashAPI.criarTabela();
			CashAPI.reload();
		}

	}

	@Override

	public void onDisable() {
		CashAPI.getDB().closeConnection();
		Bukkit.getConsoleSender().sendMessage("§c§lCONSOLE §fPlugin desativado com sucesso!");

	}

	private void getEvents() {

		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new AtlasEvent(), this);
		pm.registerEvents(new PlayerListener(), this);
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new InventoryEvent(), this);
		pm.registerEvents(new GamesMenu(), this);
		pm.registerEvents(new PlayerSetItem(), this);
	}

	private void getCommands() {

		getCommand("npccreate").setExecutor(new NpcCommand());
		getCommand("cash").setExecutor(new CashComando());
	}

	private void BukkitConfig() {

		getConfig().options().copyDefaults(false);
		saveDefaultConfig();

	}

	public String getNpcServidores() {
		return npcServidores;
	}

	public void setNpcServidores(String npcServidores) {
		this.npcServidores = npcServidores;
	}

}
