package utils;

import java.util.Map;

public abstract class ConfigDataManager {
    public static final Map<String, String> CONFIG_DATA = new ConfigDataReader().getConfigData();
}
