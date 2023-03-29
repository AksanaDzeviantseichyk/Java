package utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ConfigDataReader {
    private Map<String, String> configData;

    public ConfigDataReader() {
        File jsonFile = new File("src/main/resources/ConfigData.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            configData = mapper.readValue(jsonFile, new TypeReference<Map<String, String>>() {
            });

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getConfigData() {
        return configData;
    }
}

