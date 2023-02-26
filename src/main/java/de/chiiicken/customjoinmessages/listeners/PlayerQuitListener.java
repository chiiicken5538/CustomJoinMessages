package de.chiiicken.customjoinmessages.listeners;

import de.chiiicken.customjoinmessages.CustomJoinMessages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Objects;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if(CustomJoinMessages.plugin.fileConfiguration.getBoolean("SendQuitMessage")) {
            String quitMessage = "failed to load";
            try {
                quitMessage = CustomJoinMessages.plugin.fileConfiguration.getString("CustomQuitMessage");
            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }

            event.setQuitMessage(Objects.requireNonNull(quitMessage)
                    .replace("&", "§")
                    .replace("%player%", player.getName())
                    .replace("%playercount%", String.valueOf(Bukkit.getOnlinePlayers().size() - 1))
            );

        } else {
            event.setQuitMessage(null);
        }

    }
}

// hi aa