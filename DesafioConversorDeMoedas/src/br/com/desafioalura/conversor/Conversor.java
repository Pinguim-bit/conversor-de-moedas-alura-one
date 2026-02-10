package br.com.desafioalura.conversor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public static BigDecimal moedas(String moedaDe, String moedaPara, int valor){
        String API_KEY = ExchangerateApiConfig.getApiKey();
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + moedaDe + "/" + moedaPara;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonElement elemento = JsonParser.parseString(response.body());
            JsonObject objectRoot = elemento.getAsJsonObject();

            BigDecimal taxa = objectRoot.get("conversion_rate").getAsBigDecimal();


            return converter(valor, taxa).setScale(2, RoundingMode.HALF_UP);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static BigDecimal converter(int valor, BigDecimal taxa){
        try {
            BigDecimal valorConvertido = new BigDecimal(valor);
            return  valorConvertido.multiply(taxa);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
