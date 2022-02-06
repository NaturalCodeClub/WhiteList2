package org.wangxyper.WhiteListPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.wangxyper.WhiteListPlugin.commands.CommandWhiteList;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            Utils.pluginConfig = this.getConfig();
            Utils.init();
            Thread.sleep(1000);
            Bukkit.getPluginManager().registerEvents(new CommandWhiteList(),this);
            Bukkit.getPluginCommand("whitelist").setExecutor(new CommandWhiteList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
