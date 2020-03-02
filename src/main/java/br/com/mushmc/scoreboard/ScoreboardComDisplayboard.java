package br.com.mushmc.scoreboard;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import br.com.mushmc.apisdoedu.DisplayBoard;
import br.com.mushmc.tag.ScoreTag;

/**
 * Criando uma Scoreboard simples usando a api {@link DisplayBoard}
 * 
 * @author Eduard
 * @see DisplayBoard
 * @see Scoreboards
 */
public class ScoreboardComDisplayboard extends BukkitRunnable implements Listener {
	/**
	 * HashMap guarda a scoreboard de cada jogador
	 */
	private static HashMap<Player, DisplayBoard> scoreboards = new HashMap<>();

	/**
	 * Ao entrar setamos a score para o jogador
	 * 
	 * @param e Evento de entrar
	 */
	@EventHandler
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		setScore(p);

	}

	/**
	 * Ligar o sistema
	 * 
	 * @param plugin Plugin do sistema
	 */
	public static void ligar(JavaPlugin plugin) {
		// iniciando a scoreboard
		ScoreboardComDisplayboard simpleScore = new ScoreboardComDisplayboard();

		// ligando o timer da scoreboard
		simpleScore.runTaskTimerAsynchronously(plugin, 20, 20);

		// registro eventos da classe
		Bukkit.getPluginManager().registerEvents(simpleScore, plugin);
	}

	/**
	 * Setar Scoreboard para um Jogador
	 * 
	 * @param p Jogador
	 */
	public static void setScore(Player p) {
		// ligando uma Displayboard nova
		// Colocando o titulo e depois as linhas em seguida separadas por Virgula
		DisplayBoard scoreboard = new DisplayBoard("§6§lMEU SERVER", "§aLINHA1", "§aLinha2 $player_health", "", "§aLinha4");
		// aplica a scoreboard para o Jogador
		scoreboard.apply(p);

		// remove as linhas da Scoreboard
		scoreboard.clear();

		// limpa a lista de linhas da Scoreboard
		scoreboard.getLines().clear();



		// coloca a nova Displayboard do player criada no HashMap
		scoreboards.put(p, scoreboard);
	}

	/**
	 * Ao sair do servidor será removido a scoreboard do jogador da HashMap
	 * 
	 * @param e Evento de Sair
	 */
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		scoreboards.remove(p);

	}

	/**
	 * Metodo de atualizar a Scoreboard de todos os jogadores, ele é executado a
	 * cada 1 segundo pelo Timer iniciado no método ligar()
	 * 
	 */
	public void run() {// for para cada 'foreach'
		for (Player p : Bukkit.getOnlinePlayers()) {
			//p.sendMessage("§aEssa mensagem esta sendo enviada pra todos pelo for");
			atualizar(p);
		}
	}

	/**
	 * Atualizar a scoreboard de um Jogador
	 * 
	 * @param p Jogador
	 */
	public static void atualizar(Player p) {
		// puxa a scoreboard atual do jogador
		DisplayBoard scoreboard = scoreboards.get(p);
		// checa se a scoreboard é nula e se for return para parar o codigo
		if (scoreboard == null)
			return;
		// seta o titulo da scoreboard
		scoreboard.setDisplay("§b§lMUSH");
		// seta um linha expecifica do jeito que quiser
		scoreboard.empty(15);
		scoreboard.set(14, "§fRank: " + ScoreTag.getPlayerGroup(p));
		scoreboard.empty(13);
		scoreboard.set(12, "§fLobby: §a#1");
		scoreboard.set(11, "§fJogadores: §b" + Bukkit.getOnlinePlayers().size());
		scoreboard.empty(10);
		scoreboard.set(9, "§awww.mushmc.com.br");
		// deixa uma linha em branca (vazia)

	}

}
