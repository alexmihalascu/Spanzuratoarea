import javax.swing.*;
import java.util.List;

public class JocSpanzuratoarea {
    public static void main(String[] args) {
        // Încărcați cuvintele din fișierul cuvinte.txt
        IncarcatorCuvinte incarcatorCuvinte = new IncarcatorCuvinte("cuvinte.txt");
        List<String> cuvinte = incarcatorCuvinte.incarcaCuvinte();

        SwingUtilities.invokeLater(() -> {
            FereastraSpanzuratoarea fereastra = new FereastraSpanzuratoarea(cuvinte);
            fereastra.setVisible(true);
        });
    }
}