import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonSyntaxException;

public class Principal {
    public static void main(String[] args) {
        
        int opcion = 0; 
        String monedaorigen = "";      
        String monedadestino = "";
        List<String> respuestas = new ArrayList<>();

        ConsultarConversion consulta = new ConsultarConversion();
        ObtenerConversion calcularconversion = new ObtenerConversion(consulta);
        GuardarConversion guardarconversion = new GuardarConversion();
        
        String menu = """
                \n
                -----------------------------------------------
                +++Exchange Challenge - Currency conversion+++

                1-ARS - Peso argentino a USD
                2-BOB - Boliviano boliviano a USD
                3-BRL - Real brasileño a USD
                4-CLP - Peso chileno a USD
                5-COP - Peso colombiano a USD
                6-USD - Dólar estadounidense a USD
                
                7-Salir
                ------------------------------------------------
                """;
        
        Scanner lectura = new Scanner(System.in);        

        while (opcion != 7) {
            try {
                System.out.println(menu);
                System.out.println("Seleccione conversión a realizar:");
                opcion = Integer.parseInt(lectura.nextLine());

                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj); 

                switch (opcion) {
                    case 1:
                        monedaorigen = "ARS";
                        monedadestino = "USD";
                        break;
                    case 2:
                        monedaorigen = "BOB";
                        monedadestino = "USD";
                        break;
                    case 3:
                        monedaorigen = "BRL"; 
                        monedadestino = "USD";                       
                        break;
                    case 4:
                        monedaorigen = "CLP"; 
                        monedadestino = "USD";                       
                        break;
                    case 5:
                        monedaorigen = "COP"; 
                        monedadestino = "USD";                       
                        break;
                    case 6:
                        monedaorigen = "USD"; 
                        monedadestino = "ARS";                       
                        break;

                    case 7:
                        break;
                    default:
                        System.out.println("Seleccione moneda origen:");
                }
                
                if(opcion != 7) {
                    calcularconversion.guardarValor(monedaorigen, monedadestino);
                    respuestas.add(formattedDate + " - " + calcularconversion.obtenerMensajeRespuesta());
                }

            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. El valor ingresado no es válido.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. El valor ingresado no es válido.");
            }
        }
        lectura.close();
        guardarconversion.guardarTxt(respuestas);

        System.out.println("Seleccionó Salir.");
    }
}