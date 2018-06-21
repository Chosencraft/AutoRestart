package com.chosencraft.www.autorestart;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoRestartMain extends JavaPlugin
{

    public void onEnable()
    {
        saveDefaultConfig();



    }

    public void onDisable()
    {

    }


    public static Plugin getThisPlugin()
    {
        return Bukkit.getPluginManager().getPlugin("AutoRestart");
    }
}
