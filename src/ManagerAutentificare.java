import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ManagerAutentificare {

    private final String caleFisier;
    private Map<String, String> utilizatori;

    public ManagerAutentificare(String caleFisier) {
        this.caleFisier = caleFisier;
        incarcaUtilizatori();
    }

    private void incarcaUtilizatori() {
        utilizatori = new HashMap<>();
        try (BufferedReader cititor = new BufferedReader(new FileReader(caleFisier))) {
            String linie;
            while ((linie = cititor.readLine()) != null) {
                String[] parti = linie.trim().split(";");
                if (parti.length == 2) {
                    utilizatori.put(parti[0], parti[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean autentifica(String numeUtilizator, String parola) {
        String parolaCorecta = utilizatori.get(numeUtilizator);
        return parolaCorecta != null && parolaCorecta.equals(parola);
    }
}