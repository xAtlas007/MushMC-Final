package br.com.mushmc.tag;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.mushmc.apisdoedu.Extra;

public class CashComando implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;
			if (args.length == 0) {
				// /cash
				p.sendMessage("§aSeu cash: "+CashAPI.getSaldo(p));
				
			}else {
				String arg1 = args[0];
				if (arg1.equalsIgnoreCase("add")) {
					// /cash add Edu 10
					
					// /nomedocomando arg0 arg1 arg2
					
					Double valor = Extra.toDouble(args[2]);
					
					
				}
			}
			
		}

		return false;
	}

}
