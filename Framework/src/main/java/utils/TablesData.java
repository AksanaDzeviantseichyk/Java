package utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TablesData {
    private List<User> listUser = new ArrayList<User>();

    @JsonIgnoreProperties(ignoreUnknown = true)
    public TablesData(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            listUser = Arrays.asList(mapper.readValue(file, User[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<User> getListUser() {
        return listUser;
    }

}
