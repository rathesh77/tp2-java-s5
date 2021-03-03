import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import http.HttpClient;
import pokemon.PokemonStats;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        HttpClient client = new HttpClient();
        try {
            System.out.println(client.fetch("https://pokeapi.co/api/v2/pokemon?limit=100"));
            String result = client.fetch("https://pokeapi.co/api/v2/pokemon/1");

            Logger logger = Logger.getLogger(String.valueOf(Main.class));
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            // mapping faiblement typé
            JsonNode node = objectMapper.readTree(result);
            System.out.println(node.get("base_experience").intValue());

            //mapping fortement typé
            PokemonStats p = objectMapper.readValue(result, PokemonStats.class);
            objectMapper.writeValue(new File("pokemon.json"),p);

            logger.info(p.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
