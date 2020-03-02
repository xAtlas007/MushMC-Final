package br.com.mushmc.tag;

import org.bukkit.entity.Player;

import br.com.mushmc.apisdoedu.VaultAPI;

public enum Cargo {

	
	MEMBRO("§a","Membro") ,  DONO("§c[Dono]","Dono") , YOUTUBER("[youtuber]","Youtuber") , YOUTUBER_PLUS("[Y+]","YoutuberMais");
	
	
	
	
	
	
	
	
	
	
	private String tag;
	private String nome;
	
	
	
	

	private Cargo(String tag, String nome) {
		this.tag = tag;
		this.nome = nome;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public static String getTagDoCargoDaPessoa(Player p) {
		return VaultAPI.getPlayerGroupPrefix(p.getName());
	}
	
	
	
	public static Cargo getPlayerCargo(Player player) {
		for (Cargo cargo : Cargo.values()) {
			if (player.hasPermission("tag."+cargo.getNome())){
				return cargo;
			}
		}
		
		return null;
	}
	
}
