package tools;

import dataModels.IModel;
import framework.annotations.Loggable;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;

public class JacksonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    private JacksonUtils(){}

    @Loggable
    public static String toJson(IModel model) {
        try {
            return mapper.writeValueAsString(model);

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