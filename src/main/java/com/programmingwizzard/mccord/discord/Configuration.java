package com.programmingwizzard.mccord.discord;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

/*
 * @author ProgrammingWizzard
 * @date 10.02.2017
 */
public class Configuration {

    private final Map<String, Object> configurationMap = new HashMap<>();
    private final FileConfiguration fileConfiguration;

    public Configuration(FileConfiguration fileConfiguration) {
        this.fileConfiguration = fileConfiguration;
    }

    public void start() {
        for (String key : this.fileConfiguration.getKeys(false)) {
            Object object = fileConfiguration.get(key);
            if (object == null) {
                continue;
            }
            configurationMap.put(key, object);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        if (key == null || key.isEmpty()) {
            return null;
        }
        return (T) configurationMap.get("configuration." + key);
    }

}
