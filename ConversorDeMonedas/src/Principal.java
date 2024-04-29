import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        int busqueda;
        boolean salir = false;
        Conversor conversor = new Conversor();
        List<Moneda> monedas = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (!salir) {
            conversor.menu();
            busqueda = sc.nextInt();
            if (busqueda == 7) {
                salir = true;
            }else {
                List<ClavesMonedasAdmitidas> clavesMonedas = conversor.seleccionarMonedas(busqueda);
                if (clavesMonedas != null) {
                    try {
                        Moneda monedaSeleccionada = consultaMoneda.traerMoneda(clavesMonedas.get(0), clavesMonedas.get(1));
                        System.out.println("Ingrese el monto a convertir en " + monedaSeleccionada.base_code() + ": ");
                        double monto = sc.nextDouble();
                        double montoConvertido = conversor.convertirMoneda(monto, monedaSeleccionada.conversion_rate());
                        System.out.println("Tasa de cambio: " + monedaSeleccionada.conversion_rate());
                        System.out.println("Monto convertido: " + montoConvertido + " " + clavesMonedas.get(1));
                    }catch (Exception e){
                        System.out.println("Ocurrió un error: ");
                        System.out.println(e.getMessage());
                    }

                }
            }
        }
    }
}
