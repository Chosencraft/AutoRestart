package com.chosencraft.www.autorestart.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConversionTasks
{

    private FileConfiguration config;
    private String pathToRestartTime = "restartTime";


    public ConversionTasks (Plugin plugin)
    {
        this.config = plugin.getConfig();
    }





    /**
     * Returns the time in which the plugin is set to restart
     *
     * @return The time in which the plugin is to restart
     */
    public Calendar parseFromConfig() throws ParseException, InvalidConfigurationException
    {
        Calendar calendarDate = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");

        String restartTime = config.getString(pathToRestartTime);

        if (restartTime.length() >= 5)
        {
            // Get current time
            Time time = new Time(dateFormat.parse(restartTime.substring(0,4)).getTime());
            calendarDate.setTime(time);

            if (restartTime.length() == 7)
            {
                if (restartTime.endsWith("pm") || restartTime.endsWith("PM"))
                {
                    calendarDate.set(Calendar.HOUR_OF_DAY, (calendarDate.get(Calendar.HOUR_OF_DAY) + 12) );
                }
            }

            return calendarDate;
        }
        else
        {
            throw new InvalidConfigurationException();
        }


    }

}
