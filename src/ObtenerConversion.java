import java.util.Scanner;

public class ObtenerConversion {
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
    ConsultarConversion conversion;

    public ObtenerConversion(ConsultarConversion conversion) {
        this.conversion = conversion;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void guardarValor(String monedaOrigen, String monedaDestino){
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;

        System.out.println("Ingrese cantidad a convertir:");

        this.cantidad = Double.parseDouble(lectura.nextLine());
    }    

    public String obtenerMensajeRespuesta() {
        String mensaje = getMonedaOrigen().toUpperCase() + " " + getCantidad() + " equivalentes a: " + getMonedaDestino().toUpperCase() + " " + conversion.getConversion(getMonedaOrigen(), getMonedaDestino(), getCantidad());
        System.out.println(mensaje);
        return mensaje;
    }
}
