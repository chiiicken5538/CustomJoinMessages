package de.chiiicken.customjoinmessages.listeners;

import de.chiiicken.customjoinmessages.CustomJoinMessages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if(CustomJoinMessages.plugin.fileConfiguration.getBoolean("SendQuitMessage")) {
            event.setQuitMessage(CustomJoinMessages.plugin.fileConfiguration.getString("CustomQuitMessage")
                    .replaceAll("&", "§")
                    .replaceAll("%player%", player.getName())
                    .replaceAll("%playercount%", String.valueOf(Bukkit.getOnlinePlayers().size() - 1))
            );
        } else {
            event.setQuitMessage(null);
        }

    }
}

// hi