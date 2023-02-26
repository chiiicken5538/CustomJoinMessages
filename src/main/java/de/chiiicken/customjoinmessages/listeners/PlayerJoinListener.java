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
            String firstJoinMessage = "failed to load";
            try {
                firstJoinMessage = CustomJoinMessages.plugin.fileConfiguration.getString("CustomFirstJoinMessage");
            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }

            if (firstJoinMessage != null) {
                event.setJoinMessage(firstJoinMessage
                        .replace("&", "§")
                        .replace("%player%", player.getName())
                        .replace("%playercount%", String.valueOf(Bukkit.getOnlinePlayers().size()))
                );
            }

        }

        if(CustomJoinMessages.plugin.fileConfiguration.getBoolean("SendJoinMessage")) {
            String joinMessage = "failed to load!";
            try {
                joinMessage = CustomJoinMessages.plugin.fileConfiguration.getString("CustomJoinMessage");
            } catch (NullPointerException exception) {
                exception.printStackTrace();
            }

            if (joinMessage != null) {
                event.setJoinMessage(joinMessage
                        .replace("&", "§")
                        .replace("%player%", player.getName())
                        .replace("%playercount%", String.valueOf(Bukkit.getOnlinePlayers().size()))
                    );
            }

        } else {
            event.setJoinMessage(null);
        }

    }
}
