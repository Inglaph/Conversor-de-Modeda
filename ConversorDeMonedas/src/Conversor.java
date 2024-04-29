import java.util.ArrayList;
import java.util.List;

public class Conversor {


    public void menu() {
        System.out.println("*********************************************");
        System.out.println("Seleccione una opción: ");
        System.out.println("1. Convertir:\t Dolares a Pesos Argentinos");
        System.out.println("2. Convertir:\t Peso Argentino a Dolares");
        System.out.println("3. Convertir:\t Dolares a Real Brasileño");
        System.out.println("4. Convertir:\t Real Brasileño a Dolares");
        System.out.println("5. Convertir:\t Dolares a Pesos Colombianos");
        System.out.println("6. Convertir:\t Pesos Colombianos a Dolares");
        System.out.println("7. Salir");
    }

    public List<ClavesMonedasAdmitidas> seleccionarMonedas (int opcionSeleccionada) {
        System.out.print("Seleccionaste la opción: " + opcionSeleccionada );
        List<ClavesMonedasAdmitidas> claveMonedaLista = new ArrayList<>();
        ClavesMonedasAdmitidas claveMonedaBase = null;
        ClavesMonedasAdmitidas claveMonedaDestino = null;
        switch (opcionSeleccionada) {
            case 1:
                claveMonedaBase = ClavesMonedasAdmitidas.USD;
                claveMonedaDestino = ClavesMonedasAdmitidas.ARS;
                break;
            case 2:
                claveMonedaBase = ClavesMonedasAdmitidas.ARS;
                claveMonedaDestino = ClavesMonedasAdmitidas.USD;
                break;
            case 3:
                claveMonedaBase = ClavesMonedasAdmitidas.USD;
                claveMonedaDestino = ClavesMonedasAdmitidas.BRL;
                break;
            case 4:
                claveMonedaBase = ClavesMonedasAdmitidas.BRL;
                claveMonedaDestino = ClavesMonedasAdmitidas.USD;
                break;
            case 5:
                claveMonedaBase = ClavesMonedasAdmitidas.USD;
                claveMonedaDestino = ClavesMonedasAdmitidas.COP;
                break;
            case 6:
                claveMonedaBase = ClavesMonedasAdmitidas.COP;
                claveMonedaDestino = ClavesMonedasAdmitidas.USD;
                break;
            default:
                return null;
        }
        System.out.println("  [" + claveMonedaBase+ " a " + claveMonedaDestino + "]");
        claveMonedaLista.add(claveMonedaBase);
        claveMonedaLista.add(claveMonedaDestino);
        return claveMonedaLista;
    }

    public double convertirMoneda(double monto, double tasaDeCambio) {
        return Math.round( (monto * tasaDeCambio) * 100.0) / 100.0;
    }
}
