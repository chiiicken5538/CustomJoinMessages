package de.chiiicken.customjoinmessages.listeners;

import de.chiiicken.customjoinmessages.CustomJoinMessages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if(CustomJoinMessages.plugin.fileConfiguration.getBoolean("SendFirstJoinMessage")) {
            try {
                event.setJoinMessage(Objects.requireNonNull(CustomJoinMessages.plugin.fileConfiguration.getString("CustomFirstJoinMessage"))
                        .replace("&", "§")
                        .replace("%player%", player.getName())
                        .replace("%playercount%", String.valueOf(Bukkit.getOnlinePlayers().size()))
                );
            } catch (NullPointerException exception) {
                // Couldn't replace placeholders
            }

        }

        if(CustomJoinMessages.plugin.fileConfiguration.getBoolean("SendJoinMessage")) {
            try {
                event.setJoinMessage(Objects.requireNonNull(CustomJoinMessages.plugin.fileConfiguration.getString("CustomJoinMessage"))
                        .replace("&", "§")
                        .replace("%player%", player.getName())
                        .replace("%playercount%", String.valueOf(Bukkit.getOnlinePlayers().size()))
                );
            } catch (NullPointerException exception) {
                // Couldn't replace placeholders
            }

        } else {
            event.setJoinMessage(null);
        }

    }
}
