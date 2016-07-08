package es.projectalpha.ac.events.invs;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import es.projectalpha.ac.AVC;
import es.projectalpha.ac.achievements.AchievementsType;

public class IAchievements implements Listener {

	private AVC plugin;

	public IAchievements(AVC Main){
		this.plugin = Main;
		this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
	}

	@EventHandler
	public void onInteractShops(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getName().equals(ChatColor.GREEN + "Achievements")) {
			if (e.getCurrentItem() == null) {
				return;
			}
			if (e.getCurrentItem().getItemMeta() == null) {
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName() == null) {
				return;
			}

			for (AchievementsType at : AchievementsType.values()) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(at.getDispName())) {
					e.setCancelled(true);
					p.closeInventory();

					p.sendMessage(" ");
					p.sendMessage(ChatColor.LIGHT_PURPLE + "==================================================");
					p.sendMessage(" ");

					p.sendMessage(ChatColor.AQUA + "- Name: " + ChatColor.GOLD + at.getDispName());
					if (!at.getMessage().equalsIgnoreCase("")) {
						p.sendMessage(ChatColor.AQUA + "- Message: " + ChatColor.GREEN + at.getMessage());
					}
					if (at.getReward() != 0) {
						p.sendMessage(ChatColor.AQUA + "- Reward: " + ChatColor.YELLOW + at.getReward());
					}

					p.sendMessage(" ");
					p.sendMessage(ChatColor.LIGHT_PURPLE + "==================================================");
					p.sendMessage(" ");
				}
			}
		}
	}
}
