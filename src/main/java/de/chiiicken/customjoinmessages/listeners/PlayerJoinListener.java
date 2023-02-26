package de.chiiicken.customjoinmessages.listeners;

import de.chiiicken.customjoinmessages.CustomJoinMessages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(CustomJoinMessages.plugin.fileConfiguration.getBoolean("SendFirstJoinMessage")) {
            event.setJoinMessage(CustomJoinMessages.plugin.fileConfiguration.getString("CustomFirstJoinMessage")
                    .replaceAll("&", "§")
                    .replaceAll("%player%", player.getName())
                    .replaceAll("%playercount%", String.valueOf(Bukkit.getOnlinePlayers().size()))
            );
        }

        if(CustomJoinMessages.plugin.fileConfiguration.getBoolean("SendJoinMessage")) {
            event.setJoinMessage(CustomJoinMessages.plugin.fileConfiguration.getString("CustomJoinMessage")
                    .replaceAll("&", "§")
                    .replaceAll("%player%", player.getName())
                    .replaceAll("%playercount%", String.valueOf(Bukkit.getOnlinePlayers().size()))
            );
        } else {
            event.setJoinMessage(null);
        }

    }
}
