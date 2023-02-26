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
        fileConfiguration.addDefault("CustomJoinMessage", "&8[&6+&8] &7%player% joined! &8(%playercount%)");
        fileConfiguration.addDefault("SendQuitMessage", true);
        fileConfiguration.addDefault("CustomQuitMessage", "&8[&4-&8] &7%player% left! &8(%playercount%)");
        fileConfiguration.addDefault("SendFirstJoinMessage", true);
        fileConfiguration.addDefault("CustomFirstJoinMessage", "&8[&6b+&8] &7%player% is new here! &8(%playercount%)");

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
