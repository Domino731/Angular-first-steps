package utils.json;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// TODO add tests
public class Json {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

}
