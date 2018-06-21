package com.chosencraft.www.autorestart;

import com.chosencraft.www.autorestart.utils.ConversionTasks;
import com.chosencraft.www.autorestart.utils.Logger;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.text.ParseException;
import java.util.Calendar;

public class ShutdownTask implements Runnable
{
    private Plugin plugin;
    private FileConfiguration config;
    private Calendar restartTime;
    private Logger log = Logger.getInstance();
    private int hourInMilliseconds = 3600000;

    public ShutdownTask (Plugin plugin)
    {
        this.plugin = plugin;
        this.config = plugin.getConfig();

        try
        {
            this.restartTime = new ConversionTasks(plugin).parseFromConfig();
        }
        catch (ParseException  parseException)
        {
            log.logError("Unable to parse timestamp from config file for 'restartTime' !");
            parseException.printStackTrace();
        }
        catch (InvalidConfigurationException configurationException)
        {
            log.logError("'restartTime' in config file is in an invalid format!");
            configurationException.printStackTrace();
        }
    }


    @Override
    public void run()
    {
        long differnce = restartTime.getTimeInMillis() - System.currentTimeMillis();
        if (differnce <= hourInMilliseconds )
        {
            //TODO: start countdown task
        }


    }

}
