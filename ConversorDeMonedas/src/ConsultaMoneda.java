import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ConsultaMoneda {
    public Moneda traerMoneda(ClavesMonedasAdmitidas claveMonedaBase, ClavesMonedasAdmitidas claveMonedaDestino) {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/e8be7e4150eb420aaddb1c05/pair/"+ claveMonedaBase  +"/" + claveMonedaDestino);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("No se encontro la moneda, error:" + e.getMessage());
        }
        return null;
    }
}
