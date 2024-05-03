package com.screenmatch.projeto.ProjetoSpring;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class ConsumoApi {

    public JSONObject obterDados(String endereco){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = null;
        try {

            response = client.send(request, HttpResponse.BodyHandlers.ofString());


        } catch (IOException e) {
            System.out.println("Erro");
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("erro ao obter os dados do servidor");
            throw new RuntimeException(e);
        }

        JSONObject json = new JSONObject(response.body());
        return json;


    }

}
