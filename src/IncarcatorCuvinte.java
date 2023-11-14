import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IncarcatorCuvinte {

    private String caleFisier;

    public IncarcatorCuvinte(String caleFisier) {
        this.caleFisier = caleFisier;
    }

    public List<String> incarcaCuvinte() {
        List<String> cuvinte = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caleFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                cuvinte.add(linie);
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului: " + caleFisier);
            e.printStackTrace();
        }
        return cuvinte;
    }
}