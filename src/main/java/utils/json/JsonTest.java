package utils.json;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

import static org.junit.Assert.*;

public class JsonTest {

    private static String exampleJson = "{ \"title\": \"Lord of the rings\" }";

    @org.junit.Test
    public void parse() throws IOException {
        JsonNode node = Json.parse(exampleJson);
        assertEquals(node.get("title").asText(), "Lord of the rings+");
    }
}