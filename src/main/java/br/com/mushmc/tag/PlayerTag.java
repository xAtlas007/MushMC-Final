package br.com.mushmc.tag;

import org.bukkit.entity.Player;

import br.com.mushmc.apisdoedu.MineReflect;

public class PlayerTag {

	public final static String getPlayerGroup(final Player p) {
		
		if (p.hasPermission("tag.dono")) {
			p.setPlayerListName("0§aDono "+p.getName());
			return "";
			//MineReflect.sendNameTag(p, "§d§lDONO §f", "", "1");
		} else if (p.hasPermission("tag.admin")) {
			return "§4Admin";
		} else if (p.hasPermission("tag.mod+")) {
			return "§5Mod+";
		} else if (p.hasPermission("tag.mod")) {
			return "§5Mod";
		} else if (p.hasPermission("tag.builder")) {
			return "§2Builder";
		} else if (p.hasPermission("tag.beta")) {
			return "§1Beta";
		} else if (p.hasPermission("tag.yt+")) {
			return "§3YT+";
		} else if (p.hasPermission("tag.yt")) {
			return "§bYT";
		} else if (p.hasPermission("tag.2020")) {
			return "§b2020";
		} else if (p.hasPermission("tag.2019")) {
			return "§b2019";
		} else if (p.hasPermission("tag.2018")) {
			return "§b2018";
		} else if (p.hasPermission("tag.2017")) {
			return "§b2017";
		} else if (p.hasPermission("tag.natal")) {
			return "§cNatal";
		} else if (p.hasPermission("tag.enderlore")) {
			return "§5Enderlore";
		} else if (p.hasPermission("tag.ferias")) {
			return "§aFérias";
		} else if (p.hasPermission("tag.ultra")) {
			return "§dUltra";
		} else if (p.hasPermission("tag.master")) {
			return "§6Master";
		} else if (p.hasPermission("tag.blade")) {
			return "§eBlade";
		} else if (p.hasPermission("tag.pro")) {
			return "§6Pro";
		} else if (p.hasPermission("tag.spro")) {
			return "§eSpro";
		} else if (p.hasPermission("tag.mvp")) {
			return "§9Mvp";
		} else if (p.hasPermission("tag.vip")) {
			return "§aVip";
		}
		return "§7Membro";
	}
}