package es.projectalpha.ac.cooldowns;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import es.projectalpha.ac.game.Currency;
import es.projectalpha.ac.shops.ShopsCore;
import es.projectalpha.ac.utils.Messages;

public class Cooldowns {

	public static HashMap<String, ShopCooldown> cooldownPlayers = new HashMap<String, ShopCooldown>();

	public static void add(String player, String ability, long seconds, long systime){
		if (!cooldownPlayers.containsKey(player)) {
			cooldownPlayers.put(player, new ShopCooldown(player));
		}
		if (isCooling(player, ability)) {
			return;
		}
		cooldownPlayers.get(player).cooldownMap.put(ability, new ShopCooldown(player, seconds * 1000, System.currentTimeMillis()));
	}

	public static boolean isCooling(String player, String ability){
		if (!cooldownPlayers.containsKey(player))
			return false;
		if (!cooldownPlayers.get(player).cooldownMap.containsKey(ability))
			return false;
		return true;
	}

	public static double getRemaining(String player, String ability){
		if (!cooldownPlayers.containsKey(player))
			return 0.0;
		if (!cooldownPlayers.get(player).cooldownMap.containsKey(ability))
			return 0.0;
		return UTime.convert((cooldownPlayers.get(player).cooldownMap.get(ability).seconds + cooldownPlayers.get(player).cooldownMap.get(ability).systime) - System.currentTimeMillis(), UTime.SECONDS, 1);
	}

	public static void coolDurMessage(Player player, String ability){
		if (player == null) {
			return;
		}
		if (!isCooling(player.getName(), ability)) {
			return;
		}
		player.sendMessage(Messages.prefix + ChatColor.RED + WordUtils.capitalizeFully(ability) + ChatColor.GRAY + ": " + ChatColor.AQUA + getRemaining(player.getName(), ability));
	}

	public static void removeCooldown(String player, String ability){
		if (!cooldownPlayers.containsKey(player)) {
			return;
		}
		if (!cooldownPlayers.get(player).cooldownMap.containsKey(ability)) {
			return;
		}
		cooldownPlayers.get(player).cooldownMap.remove(ability);
		Player cPlayer = Bukkit.getPlayer(player);
		if (player != null) {
			cPlayer.sendMessage(Messages.prefix + ChatColor.GRAY + "Complete: " + ChatColor.AQUA + WordUtils.capitalizeFully(ability));
			Currency.addCurrency(Bukkit.getPlayer(player), ShopsCore.getReward(ability));
		}
	}

	public static void handleCooldowns(){
		if (cooldownPlayers.isEmpty()) {
			return;
		}

		for (Iterator<String> it = cooldownPlayers.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			for (Iterator<String> iter = cooldownPlayers.get(key).cooldownMap.keySet().iterator(); iter.hasNext();) {
				String name = iter.next();
				if (getRemaining(key, name) <= 0.0) {
					removeCooldown(key, name);
				}
			}
		}
	}
}
