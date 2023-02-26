package de.chiiicken.customjoinmessages;

import de.chiiicken.customjoinmessages.listeners.PlayerJoinListener;
import de.chiiicken.customjoinmessages.listeners.PlayerQuitListener;
import de.chiiicken.customjoinmessages.metrics.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomJoinMessages extends JavaPlugin {

    public static CustomJoinMessages plugin;
    public FileConfiguration fileConfiguration = this.getConfig();

    @Override
    public void onEnable() {
        plugin = this;

        Metrics metrics = new Metrics(this, 17818);

        fileConfiguration.addDefault("SendJoinMessage", true);
        fileConfiguration.addDefault("CustomJoinMessage", "%player% joined");
        fileConfiguration.addDefault("SendQuitMessage", true);
        fileConfiguration.addDefault("CustomQuitMessage", "%player% left");
        fileConfiguration.addDefault("SendFirstJoinMessage", true);
        fileConfiguration.addDefault("CustomFirstJoinMessage", "%player% is new on this server!");

        fileConfiguration.options().copyDefaults(true);

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(), this);

        System.out.println("[CustomJoinMessages] CustomJoinMessages version " + this.getDescription().getVersion() +
                           " by " + this.getDescription().getAuthors() + " loaded!");

        this.saveConfig();
    }

    @Override
    public void onDisable() {
        System.out.println("[CustomJoinMessages] CustomJoinMessages version " + this.getDescription().getVersion() +
            " by " + this.getDescription().getAuthors() + " unloaded. Goodbye!");
    }

}
