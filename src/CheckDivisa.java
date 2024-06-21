import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CheckDivisa {

    //Convertimos el valor de una unidad de la divisa base al monto equivalente en la divisa objetivo.
    //Esto devuelve un objeto de tipo conversion
    public Conversion realizarConversion(String base, String target) {

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        //Con pair en la URI realizamos la conversion directa mediante los codigos de las divisas.
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/fcc2447803c430ba0b038d79/pair/" + base +  "/" + target);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Conversion conversionDivisas = new Conversion(gson.fromJson(response.body(), DivisaRecord.class));

            return conversionDivisas;

        }catch (Exception e){
            throw new RuntimeException("No es posible la conversion - " + e.getMessage());
        }

    }

    //Calculamos la conversion, dado el objeto de conversion y el valor a convertir.
    public void calcularConversion(Conversion conversion, double valorAConvertir){
        double valorFinal = 0;

        if (valorAConvertir < 0){
            valorAConvertir*=-1;
            System.out.println("~ Pasamos tu valor indicado a un valor positivo: " + valorAConvertir);
        }

        valorFinal = conversion.getValorCambio() * valorAConvertir;

        System.out.println("\n~ " + valorAConvertir + " "+ conversion.getBaseDivisa() + " equivalen a: " +
                valorFinal + " " + conversion.getTargetDivisa());
        System.out.println("------------------------------------------");

    }


}
