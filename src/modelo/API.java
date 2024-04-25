package teste;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {
    String chave = "2cda53d158837d9acb89f6eb";
    String api = "https://v6.exchangerate-api.com/v6/" + chave + "/latest/USD";
    ConversorMoedas moedas;

    public API() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        JsonElement jsonElement = gson.fromJson(response.body(), JsonElement.class);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        moedas = new ConversorMoedas(gson.fromJson(jsonObject.getAsJsonObject("conversion_rates"), Moedas.class));
    }

    public ConversorMoedas getMoeda() {
        return this.moedas;
    }
}
