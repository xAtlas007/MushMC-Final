package br.com.mushmc.tag;

import org.bukkit.entity.Player;

public enum Rank {
	
	
	VACA("Vaca","§a") , CAVALO("Cavalo","§b");
	
	private String tag;
	private String name;
	
	

	private Rank(String name, String tag) {
		this.name = name;
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Rank getRankDoPlayer(Player p) {
		for(Rank rank : Rank.values()) {
			if (p.hasPermission("rank."+rank.getName())) {
				return rank;
			}
		}
		return null;
	}
	

}
