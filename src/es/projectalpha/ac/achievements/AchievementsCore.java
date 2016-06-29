package es.projectalpha.ac.achievements;

import java.util.List;

import org.bukkit.entity.Player;

import es.projectalpha.ac.files.Files;
import es.projectalpha.ac.game.Currency;
import es.projectalpha.ac.game.Game;

public class AchievementsCore {

	public static void addAchievement(Player p, AchievementsType at){
		if (!hasAchievement(p, at)) {
			List<String> players = Files.achie.getStringList(at.toString());

			players.add(p.getName());

			Files.achie.set(at.toString(), players);
			Files.saveFiles();

		} else {
			//TODO: Messages
		}
	}

	public static void remAchievement(Player p, AchievementsType at){
		if (hasAchievement(p, at)) {
			List<String> players = Files.achie.getStringList(at.toString());

			players.add(p.getName());

			Files.achie.set(at.toString(), players);
			Files.saveFiles();
		} else {
			//TODO: Messages
		}
	}

	private static boolean hasAchievement(Player p, AchievementsType at){
		if (Files.achie.getStringList(at.toString()).contains(p)) {
			return true;
		}
		return false;
	}

	public static void checkAchievements(){
		for (Player p : Game.playing) {
			if (Currency.getCurrency(p) >= 5000) {
				AchievementsCore.addAchievement(p, AchievementsType.PC);
			}
		}
	}
}
