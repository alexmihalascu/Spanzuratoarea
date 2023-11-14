import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

public class PanouSpanzuratoarea extends JPanel {

    private final List<String> cuvinte;
    private String cuvantCurent;
    private StringBuilder cuvantGhicit;
    private int incercariEsuate;
    private JLabel etichetaCuvantGhicit;
    private JButton[] butoaneLitere;

    public PanouSpanzuratoarea(List<String> cuvinte) {
        this.cuvinte = cuvinte;
        setLayout(new BorderLayout());
        initComponents();
        incepeJocNou();
    }

    private void initComponents() {
        etichetaCuvantGhicit = new JLabel("", SwingConstants.CENTER);
        etichetaCuvantGhicit.setFont(new Font("Monospaced", Font.BOLD, 24));
        add(etichetaCuvantGhicit, BorderLayout.NORTH);

        JPanel panouButoane = new JPanel(new GridLayout(3, 9, 5, 5));
        butoaneLitere = new JButton[26];
        for (int i = 0; i < 26; i++) {
            butoaneLitere[i] = new JButton(String.valueOf((char) ('A' + i)));
            butoaneLitere[i].addActionListener(new AscultatorButoane());
            panouButoane.add(butoaneLitere[i]);
        }
        add(panouButoane, BorderLayout.CENTER);
    }

    private void incepeJocNou() {
        Random random = new Random();
        cuvantCurent = cuvinte.get(random.nextInt(cuvinte.size())).toUpperCase();
        cuvantGhicit = new StringBuilder("_".repeat(cuvantCurent.length()));
        etichetaCuvantGhicit.setText(cuvantGhicit.toString());
        incercariEsuate = 0;

        for (JButton buton : butoaneLitere) {
            buton.setEnabled(true);
        }
    }

    private class AscultatorButoane implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton butonApasat = (JButton) e.getSource();
            butonApasat.setEnabled(false);
            char literaApasata = butonApasat.getText().charAt(0);

            boolean ghicitCorect = false;
            for (int i = 0; i < cuvantCurent.length(); i++) {
                if (cuvantCurent.charAt(i) == literaApasata) {
                    cuvantGhicit.setCharAt(i, literaApasata);
                    ghicitCorect = true;
                }
            }

            if (!ghicitCorect) {
                incercariEsuate++;
                if (incercariEsuate >= 6) {
                    int optiune = JOptionPane.showConfirmDialog(PanouSpanzuratoarea.this, "Ai pierdut! Cuvântul era: " + cuvantCurent + "\nVrei să joci din nou?", "Joc terminat", JOptionPane.YES_NO_OPTION);
                    if (optiune == JOptionPane.YES_OPTION) {
                        incepeJocNou();
                    } else {
                        System.exit(0);
                    }
                }
            } else {
                etichetaCuvantGhicit.setText(cuvantGhicit.toString());

                if (cuvantGhicit.indexOf("_") == -1) {
                    int optiune = JOptionPane.showConfirmDialog(PanouSpanzuratoarea.this, "Felicitări! Ai câștigat!\nVrei să joci din nou?", "Joc terminat", JOptionPane.YES_NO_OPTION);
                    if (optiune == JOptionPane.YES_OPTION) {
                        incepeJocNou();
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
    }
}