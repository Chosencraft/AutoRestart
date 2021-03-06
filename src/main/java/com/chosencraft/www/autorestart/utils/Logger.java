package com.chosencraft.www.autorestart.utils;

import com.chosencraft.www.autorestart.AutoRestartMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;

public class Logger
{
    private static Plugin main = AutoRestartMain.getThisPlugin();

    private static java.util.logging.Logger logger = main.getLogger();

    private String logMessage =
            ChatColor.YELLOW + "[" +
                    ChatColor.AQUA + "AutoRestart" +
                    ChatColor.YELLOW + "]" +
                    ChatColor.RED +  " [%s]" +
                    ChatColor.AQUA  + " %s" +
                    ChatColor.RESET;

    private Logger()
    {
        logger.setLevel(Level.ALL);
    }

    private static Logger instance = new Logger();

    public static Logger getInstance()
    {
        return instance;
    }


    public void logWarning(String... message)
    {
        for (String line : message)
        {
            logger.log(Level.WARNING, String.format(logMessage, "WARNING", line));
        }
    }

    public void logError(String... message)
    {
        for (String line : message)
        {
            logger.log(Level.SEVERE, String.format(logMessage, "ERROR", line));
        }
    }

    public void logInfo(String... message)
    {
        for (String line : message)
        {
            logger.log(Level.INFO, String.format(logMessage, "INFO", line));
        }
    }
}
