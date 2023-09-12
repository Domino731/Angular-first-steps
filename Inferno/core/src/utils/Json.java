package utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class for working with JSON data using the Jackson ObjectMapper.
 */
public class Json {

    // Create a default ObjectMapper instance.
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    /**
     * Creates and returns a default ObjectMapper instance.
     *
     * @return A configured ObjectMapper instance.
     */
    private static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        return defaultObjectMapper;
    }

    /**
     * Parses a JSON string into a JsonNode.
     *
     * @param source The JSON string to parse.
     * @return A JsonNode representing the parsed JSON structure.
     * @throws IOException If an I/O error occurs during parsing.
     */
    public static JsonNode parse(String source) throws IOException {
        return objectMapper.readTree(source);
    }

    /**
     * Parses JSON data from an InputStream into a JsonNode.
     *
     * @param source The InputStream containing the JSON data to parse.
     * @return A JsonNode representing the parsed JSON structure.
     * @throws IOException If an I/O error occurs during parsing.
     */
    public static JsonNode parse(InputStream source) throws IOException {
        return objectMapper.readTree(source);
    }

    /**
     * Deserializes a JsonNode into an instance of the specified class.
     *
     * @param node  The JsonNode to deserialize.
     * @param clazz The target class to deserialize into.
     * @param <A>   The type of the target class.
     * @return An instance of the specified class deserialized from the JsonNode.
     * @throws JsonProcessingException If a JSON processing error occurs during deserialization.
     */
    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(node, clazz);
    }

    public static JsonNode readFile(String src) {
        JsonNode json = null;
        try {
            FileHandle fileHandle = Gdx.files.internal(src);
            if (fileHandle.exists()) {
                json = Json.parse(fileHandle.readString());
            }
        } catch (IOException e) {
            EngineLog.resourceError(src);
        }

        return json;
    }
}