import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GuardarConversion {
    public void guardarTxt(List<String> lista) {
        try {
            FileWriter fileWriter = new FileWriter("historial.txt");
            for (String resultado : lista) {
                fileWriter.write(resultado);
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("Historial guardado");
        } catch (IOException e) {
            System.out.println("Error al guardar el historial: " + e.getMessage());
        }
    }
}