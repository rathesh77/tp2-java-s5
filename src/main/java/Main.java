import Http.HttpClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        HttpClient client = new HttpClient();
        try {
            System.out.println(client.fetch("https://pokeapi.co/api/v2/pokemon/charizard"));

            for ( int i = 1 ;i <= 100;i++)
                System.out.println(client.fetch("https://pokeapi.co/api/v2/pokemon/"+i));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
