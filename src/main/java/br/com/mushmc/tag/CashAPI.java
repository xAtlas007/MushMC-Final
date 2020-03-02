package br.com.mushmc.tag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import br.com.mushmc.apisdoedu.DBConnector;

public class CashAPI {
	
	private static DBConnector db = new DBConnector("root", "", "mine") ;
	public static DBConnector getDB() {
		return db;
	}
	
	private static HashMap<String, Double> cashDosJogadores = new HashMap<String, Double>();
	
	public static double getSaldo(Player p) {
		return CashAPI.cashDosJogadores.get(p.getName());
	}
	
	public static double getSaldo(String nome) {
		return CashAPI.cashDosJogadores.get(nome);
	}
	
	public static boolean temConta(Player p) {
		return cashDosJogadores.containsKey(p.getName());
	} 
	//ta auto increment, ou seja 
	public static void criarContaNoMySQL(Player p) {
		// default , 
		if(!ContaisABC(p.getName())) {
			PreparedStatement query = db.query("Insert into contas ( jogador, saldo) VALUES(?,?)");
			try {
				query.setString(1, p.getName().toLowerCase());
				query.setInt(2, 0);
				
				query.executeUpdate();
				
				cashDosJogadores.put(p.getName(), 0D);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Bukkit.getConsoleSender().sendMessage("§aDeu erro ao tentar criar conta do jogador");
			}
		}
		
	}
	public static boolean ContaisABC(String player) {
		PreparedStatement stm = null;
		try {
			stm = db.query("SELECT * FROM contas WHERE jogador = ?");
			stm.setString(1, player.toLowerCase());
			ResultSet rs = stm.executeQuery();
			while(rs.next()){ // se conter valores ...
				return true; // retorna true
			}
			return false;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public static void addCash(Player p, double saldoExtra) {
		double soma = getSaldo(p)  +  saldoExtra;
		setCash(p, soma );
	}
	public static void addCash(String name, double saldoExtra) {
		double soma = getSaldo(name)  +  saldoExtra;
		setCash(name, soma );
	}
	public static void removeCash(String name, double saldoRemovido) {
		double subtração = getSaldo(name)  -  saldoRemovido;
		setCash(name, subtração );
	}
	public static void setCash(Player p, double novoValor) {
		setCash(p.getName(), novoValor);
		
	}
	
	public static void setCash(String name, double novoValor) {
		cashDosJogadores.put(name, novoValor);
		PreparedStatement query = db.query("update contas set saldo = ? where jogador = ? ");
		
		try {
			// Substitu o ? por um valor
			// exemplo novovalor = 15
			// e p.getName() = Edu
			// vai ficar assim no final: update contas set saldo = '15' where jogador = 'Edu' 
			query.setDouble(1, novoValor);
			query.setString(2,name);
			
			query.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			Bukkit.getConsoleSender().sendMessage("§aDeu erro ao tentar alterar o saldo de cash do jogador");
		}
		
	}
	
	
	public static void criarTabela() {
		
		
		db.update("create table if not exists contas ( id integer auto_increment primary key, jogador varchar(16) , saldo double  )");
		
		
	}
	
	public static void reload() {
		
		ResultSet dados = db.select("select * from contas");
		
		try {
		
			while (dados.next()) {
				String nome = dados.getString("jogador");
				double cash = dados.getDouble("saldo");
				cashDosJogadores.put(nome, cash);
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		
	}
	
	

}
