import javax.swing.*;
import java.util.List;

public class FereastraSpanzuratoarea extends JFrame {

    public FereastraSpanzuratoarea(List<String> cuvinte) {
        setTitle("Spânzurătoarea");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        PanouSpanzuratoarea panouSpanzuratoarea = new PanouSpanzuratoarea(cuvinte);
        add(panouSpanzuratoarea);
    }
}