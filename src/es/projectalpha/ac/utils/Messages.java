package es.projectalpha.ac.utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import es.projectalpha.ac.cooldowns.Cooldowns;
import es.projectalpha.ac.game.Game;

public class Messages {

	//Game
	public static String prefix = ChatColor.GRAY + " || " + ChatColor.GREEN + "AC" + ChatColor.GRAY + " || ";

	//Shops
	public static String lemonade = "Lemonade Stand";
	public static String newspaper = "Newspaper";
	public static String car = "Car Wash";
	public static String pizza = "Pizza Delivery";
	public static String donut = "Donut Shop";
	public static String boat = "Shrimp Boat";
	public static String hockey = "Hockey Team";
	public static String movie = "Movie Studio";
	public static String bank = "Bank";
	public static String oil = "Oil Company";

	//Manager Names
	public static String lemonadeManager = "Cabe Johnson";
	public static String newspaperManager = "Perry Black";
	public static String carManager = "W.W. Heisenbird";
	public static String pizzaManager = "Mama Sean";
	public static String donutManager = "SrJonh";
	public static String boatManager = "Forest Trump";
	public static String hockeyManager = "Dawn Cheri";
	public static String movieManager = "Stefani Speilburger";
	public static String bankManager = "Cadox8";
	public static String oilManager = "Wikijito7";

	//Progress Bar
	public static String getProgress(Player p, Location l){
		int time = 0;
		String name = Game.shopLocation.get(l);

		if (ShopTimers.limonadeMaxTime() >= 100) {
			time = (int) ((Cooldowns.getRemaining(p.getName(), name) * 100) / ShopTimers.limonadeMaxTime());
		} else {
			time = (int) (Cooldowns.getRemaining(p.getName(), name) * 0.2);
		}

		if (time <= 0) {
			return ChatColor.GRAY + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 0) && (time < 6)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 5) && (time < 11)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 10) && (time < 16)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 15) && (time < 21)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 20) && (time < 26)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 25) && (time < 31)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 30) && (time < 36)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 35) && (time < 41)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 40) && (time < 46)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 45) && (time < 51)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 50) && (time < 56)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 55) && (time < 61)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 60) && (time < 66)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 65) && (time < 71)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 70) && (time < 76)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍▍▍";
		}
		if ((time > 75) && (time < 81)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍▍▍";
		}
		if ((time > 80) && (time < 86)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍▍▍";
		}
		if ((time > 85) && (time < 91)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍▍▍";
		}
		if ((time > 90) && (time < 96)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍" + ChatColor.GRAY + ChatColor.BOLD + "▍▍";
		}
		if ((time > 95) && (time < 101)) {
			return ChatColor.RED + ChatColor.BOLD.toString() + "▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍▍";
		}
		return "Error";
	}
}
