import http.HttpClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        HttpClient client = new HttpClient();
        try {
            System.out.println(client.fetch("https://pokeapi.co/api/v2/pokemon/charizard"));
            System.out.println(client.fetch("https://pokeapi.co/api/v2/pokemon?limit=100"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
