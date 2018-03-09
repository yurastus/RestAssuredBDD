package tools;

import dataModels.BaseModel;
import logging.annotations.Loggable;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

public class JacksonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    private JacksonUtils(){}

    @Loggable
    public static String toJson(BaseModel model) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(model);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Loggable
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}